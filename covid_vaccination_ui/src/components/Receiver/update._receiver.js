import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import axios from 'axios';
export default class PostList extends React.Component {
    state = {
      posts: []
    }
    
    componentDidMount() {
      axios.get(`http://localhost:8080/api/receiver`)
        .then(res => {
          
          const posts = res.data;
          
          this.setState({ posts });
          console.log(posts)
        })
    }
    
    deleteRow(id, e){
      console.log(id)
    axios.delete(`http://localhost:8080/api/receiver/${id}`)
      .then(res => {
        console.log(res);
        console.log(res.data);
        const posts = this.state.posts.filter(item => item.id !== id);
        this.setState({ posts });
      })
  
  }
    
    render() {
      return (
        <div>
          
    
          <table className="table table-bordered">
              <thead>
                <tr>
                    <th>userId</th>
                    <th>VaccineId</th>
                    <th>centerId</th>
                </tr>
              </thead>
    
              <tbody>
                {this.state.posts.map((post) => (
                  <tr>
                    <td contentEditable='true'>{post.user_id}</td>
                    <td contentEditable='true'>{post.vaccine_id}</td>
                    <td contentEditable='true'>{post.center_id}</td>
                    <td>
                      <button className="btn btn-danger" onClick={(e) => this.deleteRow(post.id, e)}>Delete</button>
                      <button className="btn btn-danger">update</button>
                    </td>
                  </tr>
                ))}
              </tbody>
    
          </table>
        </div>
      )
    }
  } 
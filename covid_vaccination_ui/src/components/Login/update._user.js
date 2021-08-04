import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import axios from 'axios';
export default class PostList extends React.Component {
    state = {
      posts: []
    }
    
    componentDidMount() {
      axios.get(`http://localhost:8080/api/user`)
        .then(res => {
          
          const posts = res.data;
          
          this.setState({ posts });
          console.log(posts)
        })
    }
    
    deleteRow(id, e){
        console.log(id)
      axios.delete(`http://localhost:8080/api/user/${id}`)
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
                    <th>Name</th>
                    <th>email</th>
                </tr>
              </thead>
    
              <tbody>
                {this.state.posts.map((post) => (
                  <tr>
                    <td contentEditable='true'>{post.name}</td>
                    <td contentEditable='true'>{post.email}</td>
                    <td>
                      <button className="btn btn-danger" onClick={(e) => this.deleteRow(post.ssn, e)}>Delete</button>
                      <button className="btn btn-danger">Update</button>
                    </td>
                  </tr>
                ))}
              </tbody>
    
          </table>
        </div>
      )
    }
  } 
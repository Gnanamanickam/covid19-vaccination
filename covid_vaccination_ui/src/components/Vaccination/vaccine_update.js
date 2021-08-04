import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import axios from 'axios';
export default class PostList extends React.Component {
    state = {
      posts: [],
      values: [],
      vaccine_name:"",
      dose:""
    }

    


    
    componentDidMount() {
      axios.get(`http://localhost:8080/api/vaccine`)
        .then(res => {
          
          const posts = res.data;
          
          this.setState({ posts });
          console.log(posts)
        })
    }
    
    deleteRow(id, e){
        console.log(id)
      axios.delete(`http://localhost:8080/api/vaccine/${id}`)
        .then(res => {
          console.log(res);
          console.log(res.data);
          const posts = this.state.posts.filter(item => item.id !== id);
          this.setState({ posts });
        })
    
    }

    updateRow(id, e){
        console.log(id)
      axios.put(`http://localhost:8080/api/vaccine/${id}`,{
         
      })
      .then(res=>{
        
      })

    
    }
    
    render() {
      return (
        <div>
         
    
          <table className="table table-bordered">
              <thead>
                <tr>
                    <th>Name</th>
                    <th>doses</th>
                    <th>type</th>
                </tr>
              </thead>
    
              <tbody>
                {this.state.posts.map((post) => (
                  <tr>
                    <td contentEditable='true'>{post.vaccine_name}</td>
                    <td contentEditable='true'>{post.doses}</td>
                    <td contentEditable='true'>{post.type}</td>
                    <td>
                      <button className="btn btn-danger" onClick={(e) => this.deleteRow(post.id, e)}>Delete</button>
                      <button className="btn btn-danger" onClick={(e) => this.updateRow(post.id, e)}>Update</button>
                    </td>
                  </tr>
                ))}
              </tbody>
    
          </table>
        </div>
      )
    }
  } 
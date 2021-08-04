import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import Axios from 'axios';
import { useHistory } from "react-router-dom";
import { NavLink } from 'react-router-dom'

export default function Receiver() {
  const url="http://localhost:8080/api/vaccine"
    const classes = useStyles();
    const [state, setState] = useState({
        name: "",
        doses: "",
        type: ""
      });

      const handleInputChange = (event) => {
        setState((prevProps) => ({
          ...prevProps,
          [event.target.name]: event.target.value
        }));
      };

      const handleSubmit = (event) => {
        event.preventDefault();
        Axios.post(url,{
          vaccine_name: state.name,
          doses:parseInt(state.doses),
          type: state.type
        })
        .then(res =>{
        //   this.props.history.push("/home"); 
       // window.location.href = '/home';
        })
        
      };
      
  
    return (
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <div className={classes.paper}>
        <NavLink to="/vaccine_update"> Show all vaccines </NavLink>
        <Typography color='primary' display='block' component="h1" variant="h5">
            Vaccines
          </Typography>
          <form className={classes.form} noValidate>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  name="name"
                  variant="outlined"
                  fullWidth
                  id="name"
                  label="name"
                  onChange={handleInputChange}
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  fullWidth
                  id="doses"
                  label="doses"
                  name="doses"
                  onChange={handleInputChange}
                 

                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  
                  fullWidth
                  id="type"
                  label="type"
                  name="type"
                  onChange={handleInputChange}
                  
                />
              </Grid>
            </Grid>
            <Button
              onClick={handleSubmit}
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className={classes.submit}
            >
              submit
            </Button>

          </form>

          
        </div>
      </Container>
    );
  }

  const useStyles = makeStyles((theme) => ({

    paper: {
        marginTop: theme.spacing(15),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },

    form: {
        width: '100%',
        marginTop: theme.spacing(2),
    },

    submit: {
        margin: theme.spacing(3, 0, 3),
    },
}));
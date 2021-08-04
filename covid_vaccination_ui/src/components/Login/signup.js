import React, { useEffect, useState } from "react";
import { Button, CssBaseline, TextField, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';
import Axios from 'axios';
import { useHistory } from "react-router-dom";
import { NavLink } from 'react-router-dom'

export default function SignUp() {
  const url="http://localhost:8080/api/user"
    const classes = useStyles();
    const [state, setState] = useState({
        email: "",
        password: "",
        firstName: "",
        phonenumber:"",
        ssn: "",
        state: "",
        county: "",
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
          ssn: parseInt(state.ssn),
          name: state.firstName,
          phone_number: parseInt(state.phonenumber),
          email: state.email,
          password: state.password,
          county: state.county,
          state: state.state

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
        {/* <NavLink to="/update_user1"> Show all users </NavLink> */}
        <a href="/update_user1">  
          <Button variant="contained" color="primary">
              Show all users
          </Button>  
        </a>
        <Typography color='primary' display='block' component="h1" variant="h5">
            Sign up
          </Typography>
          <form className={classes.form} noValidate>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={6}>
                <TextField
                  autoComplete="fname"
                  name="firstName"
                  variant="outlined"
                  required
                  fullWidth
                  id="firstName"
                  label="First Name"
                  onChange={handleInputChange}
                  autoFocus
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  fullWidth
                  id="lastName"
                  label="Last Name"
                  name="lastName"
                  onChange={handleInputChange}
                  autoComplete="lname"

                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  onChange={handleInputChange}
                  autoComplete="email"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  onChange={handleInputChange}
                  autoComplete="current-password"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="phonenumber"
                  label="Phone Number"
                  id="phone number"
                  onChange={handleInputChange}
                  autoComplete="phonenumber"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="ssn"
                  label="SSN"
                  type="ssn"
                  id="ssn"
                  onChange={handleInputChange}
                  autoComplete="ssn"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="county"
                  label="County"
                  type="county"
                  id="county"
                  onChange={handleInputChange}
                  autoComplete="county"
                />
              </Grid>
              <Grid item xs={12} sm={6}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="state"
                  label="State"
                  type="state"
                  id="state"
                  onChange={handleInputChange}
                  autoComplete="state"
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
              Sign Up
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link to="/login" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
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
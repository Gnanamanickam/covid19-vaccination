import React, { useEffect, useState } from "react";
import Axios from 'axios';
import { useHistory } from "react-router-dom"
import { Button, CssBaseline, TextField, FormControlLabel, Checkbox, Link, Grid, Typography, makeStyles, Container} from '@material-ui/core';


export default function Login() {

    const url="http://localhost:8080/api/getLogin";
    const history = useHistory();
    const classes = useStyles();
    const [state, setState] = useState({
        email: "",
        password: ""
      });

      const handleInputChange = (event) => {
        setState((prevProps) => ({
          ...prevProps,
          [event.target.name]: event.target.value
        }));
      };

      const handleSubmit = (event) => {
        event.preventDefault();
        Axios.get(url + "/" + state.email + "/" + state.password)
        .then(res =>{
        return history.push("/home"); 
        // window.location.href = '/home';
        })
      };

    return (
        <Container component="main" maxWidth="xs">
            <CssBaseline />
            <div className={classes.paper}>
                <Typography color='primary' display='block' component="h1" variant="h5">
                    COVID VACCINATION PORTAL
                </Typography>
                <form className={classes.form} noValidate>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email Address"
                        name="email"
                        autoComplete="email"
                        // value={state.email}
                        onChange={handleInputChange}
                        autoFocus
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        // value={state.password}
                        onChange={handleInputChange}
                        autoComplete="current-password"
                    />
                    <FormControlLabel
                        control={<Checkbox value="remember" color="primary" />}
                        label="Remember me"
                    />
                    <Button onClick={handleSubmit}
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        className={classes.submit}
                    >
                        Sign In
                    </Button>
                    <Grid container>
                        <Grid item xs>
                            <Link href="#" variant="body1">
                                Forgot password?
                            </Link>
                        </Grid>
                        <Grid item>
                            <Link to="/signUp" variant="body1">
                                {"Don't have an account? Sign Up"}
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
        marginTop: theme.spacing(25),
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
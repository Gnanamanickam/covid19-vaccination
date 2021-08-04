import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import clsx from 'clsx';
import Typography from '@material-ui/core/Typography';
import MenuItem from '@material-ui/core/MenuItem';
import './header.css';
import { Link } from 'react-router-dom';
import Container from '@material-ui/core/Container';
import Button, { buttonClasses as classes } from '@material-ui/core/Button';

export const Header = (props) => {
    const classes = useStyles();

    return (
        <div>
      <AppBar position="fixed">
        <Toolbar className={classes.toolbar}>
          <div className={classes.left} />
          <Link
            variant="h6"
            underline="none"
            color="inherit"
            className={classes.title}
            to='/'
          >
            {'Covid Vaccination Portal'}
          </Link>
          <div className={classes.right}>
            <Link
              color="inherit"
              variant="h6"
              underline="none"
              className={classes.rightLink}
              to="/login"
            >
              {'Sign In'}
            </Link>
            <Link
              variant="h6"
              underline="none"
              className={classes.rightLink}
              to="/signUp"
            >
              {'Sign Up'}
            </Link>
          </div>
        </Toolbar>
      </AppBar>
      <section className={classes.root}>
      <Container className={classes.container}>
        <h1> {'Welcome to Vaccination portal'}
        </h1>
        <div className={classes.backdrop} />
        <div className={classes.background} />
        <h3> {'This portal is used to keep track of users vaccination data.'}</h3>
        
        <h3> {'It also keeps track of stock of different vaccines available at different vaccine centres.'}</h3>
        <h2> {'Register below'}</h2>
        
        <a href="/signUp">  
            <Button variant="contained" color="primary">
                Register
            </Button>  
        </a>
        <br>
            
        </br>
        <br></br>
        <div className={classes.butt}>
            <Button href='/vaccination' variant="contained" color="secondary">
                    Add Vaccine
            </Button> 
            {/* <Button href='/vaccination' variant="contained" color="primary">
                Add Vaccination Centre
            </Button>  */}
            <Button href='/receiver' variant="contained" color="secondary">
                Add Receiver
            </Button> 
        </div>
        <br></br>
        <br></br>
        <Button href ='/home'variant="contained" color="primary">
             See results
            </Button>
      </Container>
    </section>
      
    </div>
        // <div className={classes.root}>
        //     <AppBar position="static" elevation={0} data-testId="header-appbar">
        //         <Toolbar data-testId="header-toolbar">
        //             <Typography
        //                 variant="h6"
        //                 style={{ marginTop: 10 }}
        //                 className={classes.title}
        //                 data-testId="header-typography"
        //             >
        //                 <Link to="/">
        //                     {/* <img
        //                         src=""
        //                         alt=""
        //                         style={{ width: 100 }}
        //                         className="logo__img"
        //                     /> */}
        //                     style={{
        //                         padding: 0,
        //                         textDecoration: 'none',
        //                         color: 'white',
        //                     }}
        //                     <MenuItem>COVID VACCINATION PORTAL</MenuItem>
        //                 </Link>
        //             </Typography>

        //             <div className={classes.headerOptions}>
        //                 <>
        //                     <Link
        //                         to="/login"
        //                         style={{
        //                             padding: 0,
        //                             textDecoration: 'none',
        //                             color: 'white',
        //                         }}
        //                     >
        //                         <MenuItem>Login</MenuItem>
        //                     </Link>
        //                     <Link
        //                         to="/signUp"
        //                         style={{
        //                             padding: 0,
        //                             textDecoration: 'none',
        //                             color: 'white',
        //                         }}
        //                     >
        //                         <MenuItem>Sign Up</MenuItem>
        //                     </Link>
        //                 </>
        //                 )

        //             </div>
        //         </Toolbar>
        //     </AppBar>
        // </div>
    );
};

export default  Header;

const useStyles = makeStyles((theme) => ({

    title: {
        fontSize: 24,
        color: theme.palette.common.black,
      },
      toolbar: {
        justifyContent: 'space-between',
      },
      left: {
        flex: 1,
      },
      leftLinkActive: {
        color: theme.palette.common.white,
      },
      right: {
        flex: 1,
        display: 'flex',
        justifyContent: 'flex-end',
      },
      rightLink: {
        fontSize: 16,
        color: theme.palette.common.white,
        marginLeft: theme.spacing(3),
      },
      linkSecondary: {
        color: theme.palette.secondary.main,
      },
      butt: {
        '& > *': {
            margin: theme.spacing(1),
        },
      },

    // root: {
    //     fcolor: theme.palette.common.white,
    // },

    // menuButton: {
    //     marginRight: theme.spacing(2),
    // },

    // title: {
    //     [theme.breakpoints.down('xs')]: {
    //         flexGrow: 1,
    //     },
    // },

    // headerOptions: {
    //     display: 'flex',
    //     flex: 1,
    //     justifyContent: 'flex-end',
    // },
    
    root: {
        color: theme.palette.common.white,
        position: 'relative',
        display: 'flex',
        alignItems: 'center',
        [theme.breakpoints.up('sm')]: {
          height: '80vh',
          minHeight: 500,
          maxHeight: 1300,
        },
      },
      container: {
        marginTop: theme.spacing(3),
        marginBottom: theme.spacing(14),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      },
      backdrop: {
        position: 'absolute',
        left: 0,
        right: 0,
        top: 0,
        bottom: 0,
        backgroundColor: theme.palette.common.black,
        opacity: 0.5,
        zIndex: -1,
      },
      background: {
        position: 'absolute',
        left: 0,
        right: 0,
        top: 0,
        bottom: 0,
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        zIndex: -2,
      },
}));
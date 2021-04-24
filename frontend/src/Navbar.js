import React, {Component} from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import withStyles from '@material-ui/core/styles/withStyles';
import logo from './assets/plane-logo-orange.png';

const styles = (theme) => ({
	appBar: {
		zIndex: theme.zIndex.drawer + 1,
		background: 'linear-gradient(60deg, #0075c6 40%, #13929a 60%)',
		//height: '9vh',
		paddingTop: '15px',
		alignItems: 'center',
    height: '100px'
	},
  logo: {
    display: 'block',
    //width: 'auto',
    height: '75px'
  },
    toolbar: theme.mixins.toolbar
  });


  class Navbar extends Component {
    render() {
        const { classes } = this.props;	

        return(
        <AppBar position="fixed" className={classes.appBar}>
            <Toolbar>
                <img src={logo} className={classes.logo} alt="flightSimulator"/>
            </Toolbar>
        </AppBar>
        )
    }
  }

export default withStyles(styles)(Navbar);










/*

import {Component} from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import withStyles from '@material-ui/core/styles/withStyles';

import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';


const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    menuButton: {
      marginRight: theme.spacing(2),
    },
    title: {
      flexGrow: 1,
    },
    appBar: {
		zIndex: theme.zIndex.drawer + 1,
		background: 'linear-gradient(45deg, #0075c6 40%, #13929a 60%)',
		height: '7vh',
		paddingTop: '0.7vh',
		alignItems: 'center',
	},
	toolbar: theme.mixins.toolbar
  }));


  export default function Navbar() {
    const classes = useStyles();
    return (
        <div className={classes.root}>
        <AppBar position="static" className={classes.appBar}>
            <Toolbar>
            <IconButton edge="start" className={classes.menuButton} color="inherit" aria-label="menu">
                <MenuIcon />
            </IconButton>
            <Typography variant="h6" className={classes.title}>
                News
            </Typography>
            <Button color="inherit">Login</Button>
            </Toolbar>
        </AppBar>
        </div>
    );
}

*/
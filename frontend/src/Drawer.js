import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import TextField from '@material-ui/core/TextField';
import List from '@material-ui/core/List';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import MailIcon from '@material-ui/icons/Mail';
import Button from '@material-ui/core/Button';

const drawerWidth = 350;

const useStyles = makeStyles((theme) => ({
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
    marginTop: '45px'
  },
  textfield: {
    width: '310px',
    marginLeft: '20px',
    marginTop: '20px'
  },
  button: {
    width: '150px'
  },
  // necessary for content to be below app bar
  toolbar: theme.mixins.toolbar,
}));

export default function PermanentDrawerLeft() {
  const classes = useStyles();
  const [cityFrom, setCityFrom] = useState('');
  const [cityTo, setCityTo] = useState('');

  function handleSubmit(event) {
    event.preventDefault();
    console.log('Flight: ', cityFrom, '-', cityTo); 
    //downloading flights
    //setting points on map
  }

  return (
    <div className={classes.root}>
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
        anchor="left"
      >
        <div className={classes.toolbar} />
        <form className={classes.root} noValidate autoComplete="off" onSubmit={handleSubmit}>
          <TextField className={classes.textfield} label="From" variant="outlined" id="city-from" onInput={ e=>setCityFrom(e.target.value)} />
          <br></br>
          <TextField className={classes.textfield} label="To" variant="outlined" id="city-to" onInput={ e=>setCityTo(e.target.value)} />
          <br></br>
          <br></br>
          <center><Button className={classes.button} variant="contained" color="primary" type="submit">Send</Button></center>
        </form>
        <br></br>
        <Divider />  
      </Drawer>

    </div>
  );
}

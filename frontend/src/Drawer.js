import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import TextField from '@material-ui/core/TextField';
import Divider from '@material-ui/core/Divider';
import Button from '@material-ui/core/Button';
import axios from 'axios';
import planeIcon from './assets/plane-type-icon.png';

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
  toolbar: theme.mixins.toolbar,
}));


export default function PermanentDrawerLeft(props) {
  const classes = useStyles();
  const [cityFrom, setCityFrom] = useState('');
  const [cityTo, setCityTo] = useState('');
  const [flights, setFlights] = useState([]);

  function handleSubmit(event) {
    event.preventDefault();
    console.log('Flight: ', cityFrom, '-', cityTo); 

    let body = {
      departure: cityFrom,
      destination: cityTo
    };
  
  axios.post('http://127.0.0.1:9999/getFlightsByDepartureAndDestination', body)
    .then(function (response) {
      setFlights(response.data);
      console.log('Flights:', response.data);
    })
    .catch(function (error) {
      console.log(error);
    });

    const airports = [
      ["Warsaw", 52.230727, 21.045148], 
      ["Berlin", 52.515289, 13.403762], 
      ["Beijing", 39.887460, 116.369273], 
      ["New Delhi", 28.616570, 77.219698], 
      ["Moscow", 55.749963, 37.621522], 
      ["Jakarta", -6.183294, 106.844015], 
      ["Seoul", 37.546478, 126.998589], 
      ["Cairo", 30.048488730879395, 31.238894367829374], 
      ["Mexico City", 19.40816686164374, -99.12576997745069], 
      ["London", 51.50505734583624, -0.10572548559548035], 
      ["Bangkok", 13.764579090047377, 100.5527629304543], 
      ["Santiago", -33.45724312922936, -70.63533262502777], 
      ["Singapore", 1.352437886779392, 103.83050665949912], 
      ["Ankara", 39.911719697484564, 32.898712135838664], 
      ["Madrid", 40.40755141180526, -3.680918306443891], 
      ["Rome", 41.89056510198305, 12.48861116337368], 
      ["Kyiv", 50.43844899677875, 30.579354405155126], 
      ["Paris", 48.85522356882381, 2.3443114744314175]
    ]
    
    for (let i = 0; i < airports.length; i++) { 
      if(cityFrom === airports[i][0]){
        console.log('Coordinates for ' + airports[i][0] + ': ' + airports[i][1], airports[i][2]) 
        props.setFromMarkerData({showMeFrom: true, latFrom: airports[i][1], lngFrom: airports[i][2]})
      } 
      if(cityTo === airports[i][0]){
        console.log('Coordinates for ' + airports[i][0] + ': ' + airports[i][1], airports[i][2]) 
        props.setToMarkerData({showMeTo: true, latTo: airports[i][1], lngTo: airports[i][2]})
      } 
    } 

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
        <div>  
          {flights.map(flight => (
            <div key={flight.id}>
              <div className="flightsList"> 
                <div class="row">
                  <div class="column">
                    <span className="date">{(flight.date).slice(0,10)}</span><br />
                    <span className="time">{(flight.date).slice(11,16)}</span><br />
                  </div>
                  <div class="column">
                    <img src={planeIcon} alt="plane type" width="100px" height="25px"></img><br />
                    <span className="plane">{flight.plane.manufacturer + ' ' + flight.plane.type}</span><br />
                    <span className="countries">{'From: ' + flight.startingCity.country}</span><br />
                    <span className="countries">{'To: ' + flight.destinationCity.country}</span><br />
                  </div>
                </div>
               

              </div>
              <Divider />
            </div>
          ))}
        </div>
      </Drawer>

    </div>
  );
}

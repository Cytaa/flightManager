import './App.css';
import React, { Component } from 'react'
import Navbar from './Navbar'
import Maps from './components/Maps'
import Drawer from './Drawer'

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {    
      showMeFrom: false,
      latFrom: 0,
      lngFrom: 0,
      shopMeTo: false,
      latTo: 0,
      lngTo: 0
    };
  }

  setFromMarkerData = (data) => {
    this.setState({showMeFrom: data.showMeFrom})
    this.setState({latFrom: data.latFrom})
    this.setState({lngFrom: data.lngFrom})
  }
  setToMarkerData = (data) => {
    this.setState({showMeTo: data.showMeTo})
    this.setState({latTo: data.latTo})
    this.setState({lngTo: data.lngTo})
  }

  render() {
    return (
      <div className="App">
          <Navbar />
          <Drawer setFromMarkerData = {this.setFromMarkerData} setToMarkerData={this.setToMarkerData} />
          <Maps markersData = {{
            showMeFrom: this.state.showMeFrom,
            latFrom: this.state.latFrom,
            lngFrom: this.state.lngFrom,
            showMeTo: this.state.showMeTo,
            latTo: this.state.latTo,
            lngTo: this.state.lngTo
          }}/>
      </div>
    );
  }
}

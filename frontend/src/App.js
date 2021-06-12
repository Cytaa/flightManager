import './App.css';
import React, { Component } from 'react'
import Navbar from './Navbar'
import Maps from './components/Maps'
import Drawer from './Drawer'

export default class App extends Component {
  
  render() {
    return (
      <div className="App">
          <Navbar />
          <Drawer />
          <Maps />
      </div>
    );
  }
}

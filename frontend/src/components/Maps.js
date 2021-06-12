import React, { Component } from 'react';
import { Map, GoogleApiWrapper } from 'google-maps-react';

const mapStyles = {
  width: '100vw',
  height: '100vh',
  top: '0',
  marginLeft: '0'
};
 
export class Maps extends Component {
 
  render() {
    return (
      <div className="Map">
        <Map
        google={this.props.google}
        zoom={2.5}
        style={mapStyles}
        initialCenter={
          {
            lat: 40.098603, 
            lng: -35.028874
          }
        }
        />
      </div>
    );
  }
}
 
export default GoogleApiWrapper({
  apiKey: 'AIzaSyC2GgQk1PGxJI2lj6hnseedAErLhzkrDKE'
})(Maps);
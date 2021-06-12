import React, { Component } from 'react';
import { Map, GoogleApiWrapper, Marker } from 'google-maps-react';

const mapStyles = {
  width: '100vw',
  height: '100vh',
  top: '0',
  marginLeft: '0'
};

export class Maps extends Component {

  showMeFrom=false;
  shopMeTo=false;
  latFrom=0;
  latTo=0;
  lngFrom=0;
  lngTo=0;

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
        >
          {this.showMeFrom ?  <Marker position={{lat: this.latFrom, lng: this.lngFrom}} /> : null}
          {this.showMeTo   ?  <Marker position={{lat: this.latTo, lng: this.lngTo}} /> : null}
        </Map>
      </div>
    );
  }
}
 
export default GoogleApiWrapper({
  apiKey: 'AIzaSyC2GgQk1PGxJI2lj6hnseedAErLhzkrDKE'
})(Maps);
import React, { Component } from 'react';
import { Map, GoogleApiWrapper, Marker } from 'google-maps-react';

const mapStyles = {
  width: '100vw',
  height: '100vh',
  top: '0',
  marginLeft: '0'
};

export class Maps extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }

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
          {this.props.markersData.showMeFrom ?  <Marker name={'2'} position={{lat: this.props.markersData.latFrom, lng: this.props.markersData.lngFrom}} /> : null}
          {this.props.markersData.showMeTo   ?  <Marker name={'1'} position={{lat: this.props.markersData.latTo, lng: this.props.markersData.lngTo}} /> : null}
        </Map>
      </div>
    );
  }
}
 
export default GoogleApiWrapper({
  apiKey: 'AIzaSyC2GgQk1PGxJI2lj6hnseedAErLhzkrDKE'
})(Maps);
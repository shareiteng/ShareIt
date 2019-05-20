import React, { Component } from 'react';
import { Map, GoogleApiWrapper } from 'google-maps-react';
import SearchBar from './SearchBar'
import {Button} from 'react-materialize'

const mapStyles = {
  width: '100%',
  height: '100%'
};


export class Map1 extends Component {


  state = { userLocation:
     { lat: 32, lng: 32 },
      loading: true };

  componentDidMount(props) {
    navigator.geolocation.getCurrentPosition(
      position => {
        const { latitude, longitude } = position.coords;

        this.setState({
          userLocation: { lat: latitude, lng: longitude },
          loading: false
        });
      },
      () => {
        this.setState({ loading: false });
      }
    );
  }

  render() {
    const { loading, userLocation } = this.state;
    const { google } = this.props;

    if (loading) {
      return null;
    }

    return  (
      
      <div col l8 >
          <Map google={google} initialCenter={userLocation} zoom={16} />
          <div className= "" >
          <div  className="">
               <SearchBar/  >
               </div>
               </div>
               <Button floating large className="red"  waves="light" waves="light"  icon="add" fab/>
        
      
      </div>
           
             )
           
  }
}

export default GoogleApiWrapper({
  apiKey: 'AIzaSyDCv8LRiSPWaEvGcRELhW1dOnbEYn92a0A'
})(Map1);
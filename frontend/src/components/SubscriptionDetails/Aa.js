
import React, {Component} from 'react'
import Axios from 'axios';
let username = localStorage.userid1
class Aa extends React.Component {
  
    state = {
      isLoading: true,
      users: [],
      error: null
    };
  
    fetchUsers() {
      Axios.post("http://localhost:5000/api/form_submit/getbestride",{},{
        params:{
          userId:`${username}`
        }
      })
      .then(response =>
        response.data.map(user => ({
            pName:`${user.pName}`,
            mPassengerName:`${user.mPassengerName}`,
            mVehicle:`${user.mVehicle}`,
            mLocation:`${user.mLocation}`,
            vehicleType:`${user.vehicleType}`,
            passengerList:`${user.passengerList}`,
            passengerNum:`${user.passengerNum}`,
            mDestination:`${user.mDestination}`
        }))
      )
      .then(users => {
        this.setState({
          users,
          isLoading: false
        });
      })
      .catch(error => this.setState({ error, isLoading: false }));
  }
  
    componentDidMount() {
      this.fetchUsers();
    }
    render() {
      const { isLoading, users, error } = this.state;
      return (
        <React.Fragment>
          <h1>Status</h1>
          {error ? <p>{error.message}</p> : null}
          {!isLoading ? (
            users.map(user => {
              const { pName, mPassengerName,mLocation,passengerNum,mDestination } = user;
              return (
                <div key={pName}>
                  <p>Name: {pName}</p>
                  <p>passengerList: {mPassengerName}</p>
                  <p>meeting Location: {mLocation}</p>
                  <p>Destination: {mDestination}</p>
                  <p>number of passenger: {passengerNum}</p>
                  <hr />
                </div>
              );
            })
          ) : (
            <h3>Loading...</h3>
          )}
        </React.Fragment>
      );
    }
  }
  
  export default Aa;
  
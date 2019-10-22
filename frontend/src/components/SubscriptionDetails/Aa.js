
import React, {Component} from 'react'
import Axios from 'axios';
class Aa extends React.Component {
    state = {
      isLoading: true,
      users: [],
      error: null
    };
  
    fetchUsers() {
      Axios.post("http://localhost:5000/api/form_submit/getbestride",{},{
        params:{
          userId:5
        }
      })
      .then(response =>
        response.data.map(user => ({
            mId:`${user.mId}`,
            mPassngersIdList:`${user.mPassngersIdList}`,
            mVehicle:`${user.mVehicle}`,
            avargeLatDes:`${user.avargeLatDes}`,
            vehicleType:`${user.vehicleType}`,
            passengerList:`${user.passengerList}`,
            passengerNum:`${user.passengerNum}`,
            avargeLatloc:`${user.avargeLatloc}`
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
          <h1>All Rides</h1>
          {error ? <p>{error.message}</p> : null}
          {!isLoading ? (
            users.map(user => {
              const { mId, mPassngersIdList, mVehicle,avargeLatDes,vehicleType,passengerList,passengerNum,avargeLatloc } = user;
              return (
                <div key={mId}>
                  <p>Name: {mId}</p>
                  <p>passengerList: {mPassngersIdList}</p>
                  <p>mVehicle:{mVehicle}</p>
                  <p>avargeLatDes: {avargeLatDes}</p>
                  <p>avargeLatloc{avargeLatloc}</p>
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
  
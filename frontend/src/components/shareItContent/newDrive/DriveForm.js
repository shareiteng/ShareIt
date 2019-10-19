import React, { Component} from 'react'
import { Container} from 'react-bootstrap';
import ToggleButtonGroup from 'react-bootstrap/ToggleButtonGroup'
import ToggleButton from 'react-bootstrap/ToggleButton'
import {submit} from'../../../store/actions/NewDriveAction'
import{connect }from 'react-redux'

class DriveForm extends Component{


  constructor(){
    super()

    this.state = {
        location:'',
        destination:'', 
        date:'',
        hours:'',
        remarks:'',
        vehicleNumber: '',
        vehicleType:'',
        seat:1
      
      }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
}
    
      handleChange = (e) => {
        this.setState({
          [e.target.id]: e.target.value
        })
        console.log(this.state);
      }
     
      handleSubmit = (e) => {
        e.preventDefault();
        this.props.submit(this.state)
        
        console.log(this.state);
      }
      handleChangeTog=(value, e) =>{
        this.setState({
         value: value
        });
        console.log(this.state);
      }
    render() {
       
      return (
        <Container>
        <h1> Let's Share</h1>
          <form className="form" onSubmit={this.handleSubmit}>
            <div className="input-field">
                <label htmlFor="location">Location</label>
        
                <input type="text" id='location' onChange={this.handleChange} />
            </div>
            <div className="input-field">
                <label htmlFor="destination">Destination</label>
                <input type="text" id='destination' onChange={this.handleChange} />
            </div>
            <div className="input-field">
                <label htmlFor="date">Date</label>
                <input type="datetime-local" id='date' onChange={this.handleChange} />
            </div>
            <div className="input-field">
                <label htmlFor="vehicleNumber">Car Id</label>
                <input type="text" id='vehicleNumber' onChange={this.handleChange} />
            </div>
            <div className="input-field">
                <label htmlFor="vehicletype">car Type</label>
                <input type="text" id='vehicletype' onChange={this.handleChange} />
            </div>
            <div className="input-field">
                <label htmlFor="seat">Number of seats</label>
                <input type="text" id='seat' onChange={this.handleChange} />
            </div>
            

            <h6> I'll do this ride every: </h6>
              <ToggleButtonGroup
                  type="checkbox"
                  value={this.state.value}
                  id='value'
                  onChange={this.handleChangeTog}>
                  <ToggleButton value={1}>Su</ToggleButton>
                  <ToggleButton value={2}>Mo</ToggleButton>
                  <ToggleButton value={3}>Tu</ToggleButton>
                  <ToggleButton value={4}>We</ToggleButton>
                  <ToggleButton value={5}>Th</ToggleButton>
                  <ToggleButton value={6}>Fr</ToggleButton>
                  <ToggleButton value={7}>Sa</ToggleButton>
              </ToggleButtonGroup>

                <div className="input-field">
                  <label htmlFor="remarks">Remarks</label>
                  <input type="text" id='remarks' onChange={this.handleChange} />
                </div>

              <div className="input-field">
                      <button className="btn signBtn ">Add Ride</button>
                  </div>
                
                 
        </form>
        </Container>
        )
    
    
  }
}


const mapDispatchToProps = (dispatch)=> {
  return {
    submit: (creds) => dispatch(submit(creds))
  }
}


export default connect(null,mapDispatchToProps)(DriveForm)
import React, { Component} from 'react'
import Container from 'react-bootstrap/Container'
import Form from 'react-bootstrap/Form';
import { Row, Col } from 'react-bootstrap';
import {sSubmit} from '../../../store/actions/SearchActions'
import{connect }from 'react-redux'



class SearchBar extends Component{

  constructor(){
    super()

    this.state = {
        location: '',
        desination: '',
        date:'',
        hours:'',
        locLatLng:'',
        desLatLng:''
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
        this.props.sSubmit(this.state);
        console.log(this.state);
        
      }
    
    render(){
    return (
            
      <Container  className="timef "> 
        <form onSubmit={this.handleSubmit} className="search" > 
            <Row>
                <Col>
                 <Form.Group controlId="location" >
                  <Form.Label>To</Form.Label>
                  <Form.Control as="textarea" rows="1" onChange={this.handleChange} />
                </Form.Group>
               </Col>
               <Col >
                 <Form.Group controlId="desination" >
                  <Form.Label>From</Form.Label>
                  <Form.Control as="textarea" rows="1" onChange={this.handleChange}/>
                </Form.Group>
               </Col>
             </Row>
             <Row  > 
               <Col >
                 <Form.Group controlId="date" >
                   <Form.Label>At</Form.Label>
                   <Form.Control type="datetime-local" rows="1" className=" white rounded size" onChange={this.handleChange} />
                 </Form.Group> 
               <button  className="searchBtn">  Submit  </button>
               </Col>
                </Row>
            </form>
            </Container>        
            
        )
    }
}


const mapDispatchToProps = (dispatch)=> {
  return {
    sSubmit: (creds) => dispatch(sSubmit(creds))
  }
}

export default connect(null,mapDispatchToProps)(SearchBar)

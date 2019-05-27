import React, { Component} from 'react'
import Container from 'react-bootstrap/Container'
import Form from 'react-bootstrap/Form';
import { Row, Col } from 'react-bootstrap';


class SearchBar extends Component{

    state = {
        location: '',
        distination: '',
        time:''
      }
      handleChange = (e) => {
        this.setState({
          [e.target.id]: e.target.value
        })
        console.log(this.state);
      }
      handleSubmit = (e) => {
        e.preventDefault();
        
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
                 <Form.Group controlId="distination" >
                  <Form.Label>From</Form.Label>
                  <Form.Control as="textarea" rows="1" onChange={this.handleChange}/>
                </Form.Group>
               </Col>
             </Row>
             <Row  > 
               <Col >
                 <Form.Group controlId="time" >
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
export default SearchBar
import React, { Component} from 'react'
import { Button,TextInput,DatePicker,TimePicker, Card,Row,Col, Container} from 'react-materialize'




class SearchBar extends Component{
    

    render(){
        return (
           
            <Row >
                <Col m={6} s={12} l={6}  className="push-l3">
                <Card  reveal className="blue-grey lighten-5" actions={[<a   className="" ><Button large className="grey darken-3 ">submit</Button > </a> ]}>
                       
                         <TextInput label="From "/>
                            <TextInput label="To" />
                            <DatePicker label="day"/>
                            <TimePicker label="hour "/>
                    
                </Card>
                </Col>
                </Row>
                 
                    
                
         
           
               
            
        )
    }
}
export default SearchBar
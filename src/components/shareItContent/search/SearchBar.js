import React, { Component} from 'react'
import { Button,TextInput,DatePicker,TimePicker, CardPanel,Row,Col, Container} from 'react-materialize'




class SearchBar extends Component{
    

    render(){
        return (
           
            <Row >
                <Col m={6} s={12} >
                <CardPanel className="teal">
                    <span className="white-text">
                    <TextInput label="From "/>
                            <TextInput label="To" />
                            <DatePicker label="day"/>
                            <TimePicker label="hour "/>
                    </span>
                </CardPanel>
               
                </Col>
                </Row>
                 
                    
                
         
           
               
            
        )
    }
}
export default SearchBar
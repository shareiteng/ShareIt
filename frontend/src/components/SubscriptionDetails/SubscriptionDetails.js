
import React, { Component} from 'react'
import  Accordion from 'react-bootstrap/Accordion'
import  Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import {findBestMatch} from '../../TranscanApi'
import Modala from './Modal'
class SubscriptionDetails extends Component{



   findBestMatch = () => {
       findBestMatch().then(response => {
           console.log(response);

       });
    }
    render(){
            return  (
        <Accordion className="accord" defaultActiveKey="0" >
            <Card>
                <Accordion.Toggle as={Card.Header} eventKey="0">
                My Subscription* 
                </Accordion.Toggle>
                <Accordion.Collapse eventKey="0">
                <Card.Body>
                    <ul>
                        <li>sub1</li>
                        <li>sub2</li>
                        <li>sub3</li>

                     </ul>
                </Card.Body >
                </Accordion.Collapse>
            </Card>
            <Card>
                <Accordion.Toggle as={Card.Header} eventKey="1">
                My Rides 
                </Accordion.Toggle>
                <Accordion.Collapse eventKey="1">
                <Card.Body> <ul>
                        <li>ride1</li>
                        <li>ride2</li>
                        <li>ride3</li>

                     </ul></Card.Body>
                </Accordion.Collapse>
            </Card>
            <Card>
                <Accordion.Toggle as={Card.Header} eventKey="2">
                My Commitment
                </Accordion.Toggle>
                <Accordion.Collapse eventKey="2">
                <Card.Body>
                <ul>
                        <li>ride1</li>
                        <li>ride2</li>
                        <li>ride3</li>

                     </ul>
                </Card.Body>
                </Accordion.Collapse>
            </Card>
            <Button variant="secondary" size="lg" block href='/new_drive'>
                Add New Drive
            </Button>

            <Modala/>
           
            <Button variant="secondary" size="lg" block href='/new_drive'>
                Display All the best match
            </Button>
            </Accordion>
    )
}
}
export default SubscriptionDetails

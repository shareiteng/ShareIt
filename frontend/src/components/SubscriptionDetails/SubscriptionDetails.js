
import React, { Component} from 'react'
import  Accordion from 'react-bootstrap/Accordion'
import  Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import {findBestMatch} from '../../TranscanApi'
import Modala from './Modal'
class SubscriptionDetails extends Component{
  
 
    render(){
        return  (
        <Accordion className="accord" defaultActiveKey="0" >
      
             <br/>
             <br/>
             <br/>
             <br/>
             <br/>
             <br/>
             <br/>
            <Button variant="secondary" size="lg" block href='/new_drive'>
                Add New Drive
            </Button>

            <Modala centered/>
           
          
            </Accordion>
    )
}
}
export default SubscriptionDetails

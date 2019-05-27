import React, { Component} from 'react'
import DriveForm from './DriveForm'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import SubscriptionDetails from '../../SubscriptionDetails/SubscriptionDetails';

class NewDrive extends Component{
    aaa = (e) => {
        e.preventDefault();
        
        console.log(this.state);
      }
  
    render(){
        return(
         <div>
            <Row>
            <Col sm={8}>
                 <DriveForm/>
                 </Col>
             <Col sm={4} className="ss">
               <SubscriptionDetails/>    
             </Col>
        </Row>
        
        </div>
       
            
              )
    }
    }
  
    
export default NewDrive
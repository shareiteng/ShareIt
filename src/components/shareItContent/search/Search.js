import React, { Component} from 'react'
import Map1 from './Map1'
import  SubscriptionDetails from '../../SubscriptionDetails/SubscriptionDetails'

import { Row, Col, Container} from 'react-bootstrap'


class Search extends Component{
    

    render(){
        return (
          <div className="timef">
           <Container fluid={true} className= "ss" >
          
           <Row noGutters={true}>
                <Col sm={8} md={8} >  <Map1 className="mapStyles"/>  </Col>
                <Col > <SubscriptionDetails/>  </Col>
            </Row>
            
           
                </Container>
       
                </div>
               
       
        )
    }
}

        export default Search;


    
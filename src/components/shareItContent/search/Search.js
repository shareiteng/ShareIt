import React, { Component} from 'react'
import { Row,Col, } from 'react-materialize'
import Map1 from './Map1'
import  SubscriptionContent from '../../SubscriptionDetails/SubscriptionContent'


class Search extends Component{
    

    render(){
        return (
            <div>
            
                <div>
                <div className="col s12 m8 l8 ">
                     <Map1/>
                   
                    <Col  l={4} push-l4>
                    <SubscriptionContent/>
                    </Col>
                    </div>   
            </div>
        </div>
        )
    }
}

        export default Search;


    
import React from 'react'
import {Row,Col} from 'react-bootstrap';

const FooterCom = ()=>{
    return(
        <footer className="page-footer ">
        <div className="container-a">
          <Row>
            <Col l={6} s={12} sm={8}>
                <h5 className="white-text">
                    About Us
                </h5>
                <p className="grey-text text-lighten-4">
                    We are students in the open university persouing computer science degree, and this is a project in advanced java workshop that we assigened to do.
                </p>
            </Col>
            <Col l={4} s={12} sm={4} offset="l2">
                <ul>
                    <li><a className="grey-text text-lighten-3" href="/"><i className="fa fa-facebook-official" > </i> Facebook</a></li>
                    <li><a className="grey-text text-lighten-3" href="/"> <i className="fa fa-twitter-square" > </i> Twitter</a></li>
                    <li><a className="grey-text text-lighten-3" href="/"><i className="fa fa-linkedin-square" > </i> Linked In</a></li>
                    <li><a className="grey-text text-lighten-3" href="/"><i className="fa fa-instagram" > </i> Instagram</a></li>
                </ul>
            </Col>
          </Row>
        </div>
        <div className="footer-copyright">
          <div className="container-a">
            &copy 2015 Copyright Text
          </div>
        </div>
      </footer>
  )
}
export default FooterCom



import React from 'react'
import {Footer, Icon} from 'react-materialize'


const FooterCom = ()=>{
    return(
        <Footer
            copyrights="&copy 2015 Copyright Text"
            moreLinks={<a />}
            links={<ul>
            <li><a className="grey-text text-lighten-3" href="#"><i className="fa fa-facebook-official" > </i> Facebook</a></li>
            <li><a className="grey-text text-lighten-3" href="#"> <i className="fa fa-twitter-square" > </i> Twitter</a></li>
            <li><a className="grey-text text-lighten-3" href="#"><i className="fa fa-linkedin-square" > </i> Linked In</a></li>
            <li><a className="grey-text text-lighten-3" href="#"><i className="fa fa-instagram" > </i> Instagram</a></li>
          </ul>}
            className="grey darken-3"
        >
            <h5 className="white-text">
                About Us
            </h5>
            <p className="grey-text text-lighten-4">
                We are students in the open university persouing computer science degree, and this is a project in advanced java workshop that we assigened to do.
            </p>
        </Footer>
  )
}
export default FooterCom

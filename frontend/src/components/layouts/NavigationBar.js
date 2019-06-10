import React from 'react'
import {Navbar,Nav} from 'react-bootstrap';
import cover1 from '../../img/cover1.jpg'
import LogOutLinks from './LogOutLinks'
import LogInLinks from './LogInLinks'
import{connect }from 'react-redux'



const  NavigationBar=(props)=>{
        const {auth}=props;
        const links= auth ?<LogInLinks />: <LogOutLinks />
        return(
          
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" fixed="top">
            <Navbar.Brand href="/">
                <img
                    alt=""
                    src={cover1}
                    width="20"
                    height="20"
                    className="d-inline-block align-top"
                   
                />
                Transcane   
                </Navbar.Brand>
                
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                    </Nav>
                   
                    {links}   
                 </Navbar.Collapse>
            </Navbar>

        )
    
}
const mapStateToProps=(state) => {
  return{
    auth: state.auth
  }
}

export default connect(mapStateToProps )(NavigationBar)
 
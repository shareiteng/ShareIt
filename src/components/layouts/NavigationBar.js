import React, { Component} from 'react'
import {Navbar,Nav,NavDropdown} from 'react-bootstrap';
import cover1 from '../../img/cover1.jpg'



class NavigationBar extends Component{

    render(){
        return(
            
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" fixed="top">
            <Navbar.Brand href="#home">
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
                   
                    <Nav.Link href="#"><i className="material-icons"> notifications  </i></Nav.Link>
                    <img src={cover1} alt="Avatar" className="avatar" ></img>
                    <Nav>
                    
                    <NavDropdown  title="" id="collasible-nav-dropdown" alignRight >
                        <NavDropdown.Item href="#">Account</NavDropdown.Item>
                        <NavDropdown.Item href="#">My Profile</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#">LogIn</NavDropdown.Item>
                    </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
}
export default NavigationBar
 
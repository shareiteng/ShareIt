import React, { Component} from 'react'
import {Navbar,Nav,NavDropdown, Modal} from 'react-bootstrap';
import cover1 from '../../img/cover1.jpg'
import SignIn from '../auth/SignIn'
import avatar from '../../img/avatar.png'


class NavigationBar extends Component{
    constructor(props, context) {
        super(props, context);
    
    this.handleShow = this.handleShow.bind(this);
    this.handleClose = this.handleClose.bind(this);

    this.state = {
      show: false,
    };
  }

  handleClose() {
    this.setState({ show: false });
  }

  handleShow() {
    this.setState({ show: true });
  }

    render(){
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
                   
                    <Nav.Link href="#"><i className="material-icons"> notifications  </i></Nav.Link>
                    <img src={avatar} alt="Avatar" className="avatar" ></img>
                    <Nav>
                    
                    <NavDropdown  title="" id="collasible-nav-dropdown" alignRight >
                        <NavDropdown.Item href="#">Account</NavDropdown.Item>
                        <NavDropdown.Item href="profile">My Profile</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#" onClick={this.handleShow}>LogIn</NavDropdown.Item>
                    </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Modal show={this.state.show} onHide={this.handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Sign In</Modal.Title>
          </Modal.Header>
          <Modal.Body>
              <SignIn/>
              </Modal.Body>
         
        </Modal>
            </Navbar>

        )
    }
}
export default NavigationBar
 

import React, {Component} from 'react'
import Modal from 'react-bootstrap/Modal'
import SignIn from '../auth/SignIn'
import NavLink from 'react-bootstrap/NavLink'
class LogOutLinks extends Component{
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
            
   <div> 
     <ul className="right">
        <li><NavLink href="#" onClick={this.handleShow}>LogIn</NavLink>  </li>
        <li><NavLink href="#join" >SignUp</NavLink></li>
      </ul>
             
            
                <Modal show={this.state.show} onHide={this.handleClose}>
                    < Modal.Header closeButton>
                         <Modal.Title>Sign In</Modal.Title>
                     </Modal.Header>
                    <Modal.Body>
                        <SignIn/>
                    </Modal.Body>
                  
                </Modal>
                
    </div>
                )
            }
}


export default LogOutLinks
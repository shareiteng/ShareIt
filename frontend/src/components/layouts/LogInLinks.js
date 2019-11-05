import React from 'react'
import {Navbar,Nav,NavDropdown} from 'react-bootstrap';

import avatar from '../../img/avatar.png'
import {signOut} from '../../store/actions/AuthActions'
import {connect} from 'react-redux'


const LogInLinks =(props)=>{
  
        return(
            
            <div> 
                    <Navbar.Collapse>
                    <Nav.Link href="#"><i className="material-icons"> notifications  </i></Nav.Link>
                    <img src={avatar} alt="Avatar" className="avatar" ></img>
                    <Nav>
                    
                    <NavDropdown  title="" id="collasible-nav-dropdown" alignRight >
                        <NavDropdown.Item href="/search">Search</NavDropdown.Item>
                        <NavDropdown.Item href="profile">My Profile</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#" onClick={props.signOut}>LogOut</NavDropdown.Item>
                    </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                
           
        </div>
        )
    }

const mapDispatchToProps = (dispatch) => {
    return {
      signOut: () => dispatch(signOut())
    }
  }
export default connect(null, mapDispatchToProps)(LogInLinks)

 

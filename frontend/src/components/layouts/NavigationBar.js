import React from 'react'
import {Navbar,Nav} from 'react-bootstrap';
import cover1 from '../../img/cover1.jpg'
import LogOutLinks from './LogOutLinks'
import LogInLinks from './LogInLinks'
import{connect }from 'react-redux'
import LocalStorageService from '../../LocalStorageService';
import { signOut } from '../../store/actions/AuthActions';
import { isPipelinePrimaryTopicReference } from '@babel/types';
import {isLogin} from '../../TranscanApi'


const  NavigationBar=(props)=>{
        
        console.log("********   "+LocalStorageService.getFromLocal("transanUserID"));
  //      console.log("***2222*****   "+props.auth);
        
      isLogin(LocalStorageService.getFromLocal("transanUserID")).then(response => {});
        let a=null; 
        isLogin(LocalStorageService.getFromLocal("transanUserID"));
      if(a===null)
      a=null;
      else a="sss";


        const links= a?<LogInLinks />: <LogOutLinks />
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

//TODO
const mapStateToProps=(state) => {
  return{
    auth: LocalStorageService.getFromLocal("transcanUserID")
  }
}

export default connect(mapStateToProps )(NavigationBar)
 
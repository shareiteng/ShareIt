import React from 'react'
import { Navbar,NavItem,Dropdown ,Divider} from 'react-materialize'


const NavBar = ()=>{
    return(
         <Navbar fixed className="NavBar-tmp" brand={<a>TranScan</a>} alignLinks="right">
                <NavItem href="">
                Getting started
                </NavItem>
                <NavItem href="">
                Components
                </NavItem>
                <Dropdown  trigger={<a>profile</a>}>
                <a href="#">
                one
                </a>
                <a href="#">
                two
                </a>
                <Divider/>
                <a href="#">
                three
                </a>
                </Dropdown>
            </Navbar>
    )
}
export default NavBar
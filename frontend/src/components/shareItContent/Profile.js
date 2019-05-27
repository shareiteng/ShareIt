import React, { Component} from 'react'

import avatar from '../../img/avatar.png'
import { Container } from 'react-bootstrap';


    class Profile extends Component{
       state={
           image:avatar,
       }
       
        onImageChange = (event) => {
            if (event.target.files && event.target.files[0]) {
              let reader = new FileReader();
              reader.onload = (e) => {
                this.setState({image: e.target.result});
              };
              reader.readAsDataURL(event.target.files[0]);
            }
          }
    render () {
        return (
        <div>
             <h1 id="profileName" >Idan Roas</h1>
             <img id="target" alt="img" src={this.state.image}/>
             <input type="file" onChange={this.onImageChange} className="filetype" id="group_image"/>
            
            <h5 id="profileName"> 455<i className="material-icons starIcon">star </i></h5>
            
        <h1 id="profileName">About</h1>
        <h5 id="profileName">
          about text... 
        <text className=""></text></h5>
        <Container>
        
        <h4 > <i className="material-icons ">phone</i>Phone</h4>
        <h4><i className="material-icons ">mail </i>E-Mail</h4>
        <h4 ><i className="material-icons ">home </i>address</h4>
        </Container>
        
        
        
       


        </div>
        )
    }
}
export default Profile
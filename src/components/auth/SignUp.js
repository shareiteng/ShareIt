import React, { Component} from 'react'
import { Button  , TextInput,Checkbox ,Icon ,Parallax,Collapsible,CollapsibleItem} from 'react-materialize'
import cover1 from '../../img/cover1.jpg'



class SignUp extends Component{
    
    render(){
        return (
            <div id="SignUp">

           
                <div className="intro" >

                    <div className="intro-content">
                        <Button large className="grey darken-3 btn-intro" href="#info" node='a'>More Info</Button>
                        <Button large className="grey darken-3 btn-intro" href="#join" node='a'>Join Us</Button>
                    </div> 
                    
                </div>
                <div id="info">
                        jfsdabb
                        
                        <br>
                        </br>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>
                <div>
                    <Parallax image={<img src={cover1}/>} />
                </div>
                <div id="join">
                    <div id="touch">
                    <h2 >Sign Up</h2> 
                    </div>
                    <form action="" id="contact">
                    <TextInput label="First Name" icon={<Icon>contacts</Icon>} />
                    <TextInput required label="Last Name" icon={<Icon>contacts</Icon>}/>
                    <TextInput email validate label="Email" icon={<Icon >email</Icon>} />
                    <TextInput password label="Password" icon={<Icon>security</Icon>}/>
                    <Checkbox value="have" label="I have a vehicle!" />
                    <br/>
                    <Button large className="grey darken-3 btn-intro" >Submit</Button>

                    </form>
                </div>
            </div>
        )
    }
}
export default SignUp
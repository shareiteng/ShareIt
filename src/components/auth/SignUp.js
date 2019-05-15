import React, { Component} from 'react'
import { Button} from 'react-materialize'




class SignUp extends Component{
    
    render(){
        return (
            <div className="SignUp">

           
                <div className="intro" >

                    <div className="intro-content">
                        <Button large className="grey darken-3 btn-intro" >More Info</Button>
                        <Button large className="grey darken-3 btn-intro">Sign Up</Button>
                    </div> 
                </div>
            </div>
        )
    }
}
export default SignUp
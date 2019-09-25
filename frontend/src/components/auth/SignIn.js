import React, { Component} from 'react'
  import{connect }from 'react-redux'
//import TranScanApi from '../../TranScanApi'
import {signIn} from '../../store/actions/AuthActions'



class SignIn extends Component{
  
    state = {
        usernameOrEmail: '',
        password:'',
        history:''
      }
      
      handleChange = (e) => {
        this.setState({
          [e.target.id]: e.target.value
        })
        console.log(this.state);
      }
   
        handleSubmit = (e) => {
         e.preventDefault();
         this.props.signIn(this.state, this.props.history)
        }
    
       formInput = (input) => {
        if(this.state[input]==="")
          return (input);
       return "";
      }

    render() {
    
        return (

<form className="form" onSubmit={this.handleSubmit}>
                            <div className="input-field">
                                <label htmlFor="usernameOrEmail">{this.formInput('usernameOrEmail')}</label>
                                <input type="text" id='usernameOrEmail' onChange={this.handleChange} />
                            </div>
                            
                            <div className="input-field">
                                <label id="password" htmlFor="password">{this.formInput('password')} </label>

                                <label htmlFor="password"></label>
                                <input type="password" id='password' onChange={this.handleChange} />
                            </div>
                            
                            <div className="input-field">
                                <button className="btn signBtn ">SignIn</button>
                        
                    </div>
                    </form>
        )
    
    }
}

 const mapStateToProps = (state) => {
   return{
    //authError: state.auth.authError
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    signIn: (creds, history) => dispatch(signIn(creds, history))
  }
}

export default 
connect(mapStateToProps,mapDispatchToProps)(SignIn)
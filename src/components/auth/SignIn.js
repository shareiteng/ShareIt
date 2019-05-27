import React, { Component} from 'react'
import{connect }from 'react-redux'



class SignIn extends Component{

    state = {
        email: '',
        password:''
      }
      handleChange = (e) => {
        this.setState({
          [e.target.id]: e.target.value
        })
        console.log(this.state);
      }
      handleSubmit = (e) => {
        e.preventDefault();
        this.props.signIn(this.state)
        console.log(this.state);
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
                                <label htmlFor="email">{this.formInput('email')}</label>
                                <input type="email" id='email' onChange={this.handleChange} />
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

// const mapStateToProps = (state) => {
//   return{
//     authError: state.auth.authError
//   }
// }

// const mapDispatchToProps = (dispatch) => {
//   return {
//     signIn: (creds) => dispatch(signIn(creds))
//   }
// }

export default 
//connect(mapStateToProps,mapDispatchToProps)
(SignIn)
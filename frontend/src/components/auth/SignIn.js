import React, { Component} from 'react'




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
        
        console.log(this.state);
      }

    render() {
        return (

<form className="form" onSubmit={this.handleSubmit}>
                            <div className="input-field">
                                <label htmlFor="email">Email</label>
                                <input type="email" id='email' onChange={this.handleChange} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="password">Password</label>
                                <input type="password" id='password' onChange={this.handleChange} />
                            </div>
                            
                            <div className="input-field">
                                <button className="btn signBtn ">SignIn</button>
                        
                    </div>
                    </form>
        )
    
    }
}
export default SignIn
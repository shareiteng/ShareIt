import React, { Component} from 'react'
import {Button,Row,Col, Container, Media} from 'react-bootstrap';
import img1 from '../../img/img1.png'
import img3 from '../../img/img3.jpg'
import img4 from '../../img/img4.png'
import {signUp} from '../../store/actions/AuthActions'
import{connect }from 'react-redux'


class SignUp extends Component{
    constructor(){
        super()

        this.state = {
            email: "",
            password: "",
            username: ""
            }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleChange = (e) => {
        this.setState({
        [e.target.id]: e.target.value
        })
        console.log(this.state);
    }
    handleSubmit = (e) => {
        e.preventDefault()
        this.props.signUp(this.state);

    }
    formInput = (input, text) => {
    if(this.state[input]==="")
        return (text);
    return "";
    }

    render() {
        return (

            <div id="SignUp">

                <div className="intro" >
                    <div className="  intro-content">
                        <Button size="lg" className="  transparent btn-intro" href="#info" node='a'>More Info</Button>
                        <Button size="lg" className="transparent darken-3 btn-intro" href="#join" node='a'>Join Us</Button>
                    </div> 
                    
                </div>
                <div id="info" className="bgsign">
                        <Container>
                        <br/><br/><br/>
                        <Media  >
                            <img
                                width={160}
                                height={160}
                                className="mr-3"
                                src={img1}
                                alt="Generic placeholder"
                            />
                            <Media.Body>
                                <h5>Who we are? </h5>
                                <p>
                                Transcan is a smart transformation application for help you to share 
                                your ride in the best way with other people. Togther we will match the best 
                                vehicle for take you and more people in your location to common  desteny 
                                point in the chipest and faster way.
                               
                                </p>
                            </Media.Body>
                            </Media>
                            <br/>
                            <br/>
                            <Media>
                            <img
                               
                                className="mr-3 ava"
                                width={160}
                                height={160}
                                src={img3}
                                alt="Generic placeholder"
                            />
                            <Media.Body>
                                <h5>why you must to join us?</h5>
                           <p>
                               Transcan lead a real revolotaion in the Cooperative transportation world, 
                               we develop the best algoritms to match the best vehicle for every ride and 
                               for maximum moeny and time saving. 
                               We offer you to join to a speicial monthly subscription that allow you to get your desteny 
                               with carpool, texi, minibus, or bus in fixed price and we commit that this ride will
                               heppend in any case, so you can be sure you will get your work place every mornning, 
                               get a ride for the weekly family friday meal and etc.. 
                               In addition, we cause to everyone who have a vehicle and common rout with other people
                               to save moeny, earn from the ride, and enjoy from special Tax Benefits.

                              
                                </p>
                            </Media.Body>
                            </Media>
                            
                         
                            <br/><br/>
                            <Media>
                            <img
                                width={180}
                                height={180}
                                className="mr-3"
                                src={img4}
                                alt="Generic placeholder"
                            />
                            <Media.Body>
                                <h5>For a better World</h5>
                                <p>
                                    In Every time you use the app, you get a car off the road, lowering traffic
                                    jam and Saves air pollution. 

                                </p>
                            </Media.Body>
                            </Media>
                            <br/>
                            <br/>
                            </Container>
                </div>
                
               
                <Container  id="join">
                 <Row>
                    <Col lg={6} md={3} sm={0}>
                       <br/> <br/>
                        <h1> Sign Up </h1> 
                    </Col>
                  <Col>
                         <form className="form" id='myForm' onSubmit={this.handleSubmit}>
                            <div className="input-field">
                                <label htmlFor="username">{this.formInput("username","User Name")}</label>
                                <input name="username" type="text" id="username" onChange={this.handleChange} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="email">{this.formInput("email", "E-Mail")}</label>
                                <input name="email" type="email" id="email" onChange={this.handleChange} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="password">{this.formInput("password", "Password")}</label>
                                <input name="password" type="password" id="password" onChange={this.handleChange} />
                            </div>
                            <div className="input-field">
                                <button className="btn signBtn ">Sign Up</button>
                            
                    </div>
                    </form>
                    </Col>
                    </Row>
                </Container>
                   
                </div>
           
                
        )
    }
}
const mapStateToProps = (state) => {
    return {
      auth: state.auth,
     // authError: state.auth.authError
    }
  }
  
  const mapDispatchToProps = (dispatch)=> {
    return {
      signUp: (creds) => dispatch(signUp(creds))
    }
  }
  
export default connect(mapStateToProps,mapDispatchToProps)(SignUp)
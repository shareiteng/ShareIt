import React, { Component} from 'react'
import {Button,Row,Col, Container, Media} from 'react-bootstrap';
import img1 from '../../img/img1.png'
import img3 from '../../img/img3.jpg'
import img4 from '../../img/img4.png'
import * as TranScanApi from '../../TranscanApi'

class SignUp extends Component{
    constructor(){
        super()

        this.state = {
            email: "",
            password: "",
            firstname: "",
            lastname:""
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
        const newUser ={
            email:this.state.email,
            password: this.state.password,
            firstname: this.state.firstname,
            lastname:this.state.lastname,
            address:null,
            phone:null,
            vehicle:false,
            score:0
        }

        if(TranScanApi.add(newUser)) window.location.href ="/search";
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
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                                ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                               
                                </p>
                            </Media.Body>
                            </Media>
                            <br/>
                            <br/>
                            <Media>
                            <img
                               
                                className="mr-3 ava"
                                width={140}
                                height={140}
                                src={img3}
                                alt="Generic placeholder"
                            />
                            <Media.Body>
                                <h5>why you must to join us?</h5>
                                <p>
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                                ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                              
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
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                                ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                                tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                                Donec lacinia congue felis in faucibus.
                                </p>
                            </Media.Body>
                            </Media>
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
                                <label htmlFor="firstname">{this.formInput("firstname","First Name")}</label>
                                <input name="firstname" type="text" id="firstname" onChange={this.handleChange} />
                            </div>
                            <div className="input-field">
                                <label htmlFor="lastname">{this.formInput("lastname","Last Name")}</label>
                                <input name="lastname" type="text" id="lastname" onChange={this.handleChange} />
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
export default SignUp
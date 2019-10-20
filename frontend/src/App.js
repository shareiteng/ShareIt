import React from 'react';
import SignUp from './components/auth/SignUp'
import Search from './components/shareItContent/search/Search'
import './App.css'
import NavigationBar from './components/layouts/NavigationBar';
import FooterCom from './components/layouts/FooterCom';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import NewDrive from './components/shareItContent/newDrive/NewDrive'
import Profile from './components/shareItContent/Profile';
import {loggedCheck, signUp} from './store/actions/AuthActions'
import LogInLinks from './components/layouts/LogInLinks';
import LocalStorageService from './LocalStorageService';


function App() {
  let defaultLink=SignUp;
const a= LocalStorageService.getFromLocal("transanUserID");
console.log(a+"  sss");
if(a!=='loggedout'||a!==null){
  console.log("yes");
defaultLink=Search;


}

  return (
    <BrowserRouter>
            <div className="App">
              <NavigationBar/><br/><br/> <br/>
              <Switch>
                <Route exact path='/' component={defaultLink}/>
                <Route path='/search' component={Search}/>
                <Route path='/new_drive' component={NewDrive}/>
                <Route path='/profile' component={Profile}/>
              </Switch>
              <FooterCom/>
            </div>
          </BrowserRouter>)
          ;

}

export default App;

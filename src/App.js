import React from 'react';
import SignUp from './components/auth/SignUp'
import Search from './components/shareItContent/search/Search'
import './App.css'
import NavigationBar from './components/layouts/NavigationBar';
import FooterCom from './components/layouts/FooterCom';
import { BrowserRouter, Switch, Route } from 'react-router-dom'

function App() {
  return (
    <BrowserRouter>
            <div className="App">
              <NavigationBar/>
              <Switch>
                <Route exact path='/' component={SignUp}/>
                <Route path='/search' component={Search}/>
              </Switch>
              <FooterCom/>
            </div>
          </BrowserRouter>)
          ;

}

export default App;

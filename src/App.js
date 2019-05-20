import React from 'react';
import SignUp from './components/auth/SignUp'
import NavBar from './components/layouts/NavBar'
import Search from './components/shareItContent/search/Search'
import Footer from './components/layouts/FooterCom'
import './App.css'
import { Map1 } from './components/shareItContent/search/Map1';
/*

      */
function App() {
  return (
    <div className="App">
    <NavBar></NavBar>
    <SignUp></SignUp>
    <Footer></Footer>

      
    </div>
  );
}

export default App;

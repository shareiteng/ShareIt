import React from 'react';
import SignUp from './components/auth/SignUp'
import NavBar from './components/layouts/NavBar'
import './App.css'


function App() {
  return (
    <div className="App">
      <NavBar></NavBar>
      <SignUp></SignUp>

    </div>
  );
}

export default App;

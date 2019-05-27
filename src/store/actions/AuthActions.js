
export const signIn = (credentials) => {
    return (dispatch, getState, {getFirebase}) => {
      const firebase = getFirebase();
      
      axios.get('/index/add',{
        params:{
            username: this.state.username,
            email: this.state.email,
            password: this.state.password}
        }).then(() => {
        dispatch({ type: 'LOGIN_SUCCESS' });
      }).catch((err) => {
        dispatch({ type: 'LOGIN_ERROR', err });
      });
  
    }
  }
  

export const signOut = () => {
    return (dispatch, getState, {getFirebase}) => {
      const firebase = getFirebase();
  
      firebase.auth().signOut().then(() => {
        dispatch({ type: 'SIGNOUT_SUCCESS' })
      });
    }
  }

export const signUp = (newUser) => {
   
  return (dispatch) => {
    axios.get('/index/add',{
        params:{
            username: fname,
            email: newUser.email,
            password: newUser.password}
        }).then(() => {
        dispatch({ type: 'SIGN_UP_SUCCESS' });
      }).catch((err) => {
        dispatch({ type: 'SIGNUP_ERROR', err });
      });
    }
  }
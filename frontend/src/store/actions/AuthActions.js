
import {login} from '../../TranscanApi'
import {addNewUser} from '../../TranscanApi'
export const signIn = (user) => {
    return (dispatch) => {
     
           
      login(user).then(response => {
        if(response.data)
        dispatch({ type: 'LOGIN_SUCCESS' });
        else
        dispatch({ type: 'LOGIN_ERROR'});
      });
    }
  }
    
export const signUp = (newUser) => {
  return (dispatch) => {
    addNewUser(newUser).then(response => {    
    } ).then(() => {
        dispatch({ type: 'SIGNUP_SUCCESS' });
      }).catch((err) => {
        dispatch({ type: 'SIGNUP_ERROR', err});
      });
    }
  }

  export const signOut = () => {
    return (dispatch) => {
        dispatch({ type: 'SIGNOUT_SUCCESS' })
      };
    
  }
         
  
    
  
  

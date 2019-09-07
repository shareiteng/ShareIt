
import {login} from '../../TranscanApi'
import {addNewUser} from '../../TranscanApi'
import LocalStorageService from '../../LocalStorageService';

export const signIn = (user) => {
    return (dispatch) => {          
      login(user).then(response => {
        if(response.data){
          LocalStorageService.saveToLocal("transanUserID", response.data.accessToken);
        dispatch({ type: 'LOGIN_SUCCESS' });
        console.log(response.data.accessToken);
       
        console.log("InLocalStorage: "+ LocalStorageService.getFromLocal("transanUserID"));
        }
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
     // LocalStorageService.removefromLocal("transanUserID");
        dispatch({ type: 'SIGNOUT_SUCCESS' })
      };
    
  }
         
  
    
  
  

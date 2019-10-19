
import {login} from '../../TranscanApi'
import {addNewUser} from '../../TranscanApi'
import LocalStorageService from '../../LocalStorageService';
import {isLogin, searchSubmit} from '../../TranscanApi'

export const loggedCheck =() => {
  return (dispatch) => {          
    isLogin(LocalStorageService.getFromLocal("transanUserID")).then(response => {
      if(response.data){
        dispatch({ type: 'logged' });
      }
      else  {
        // 
      dispatch({ type: 'unlogged' });
    }
});
  }
}
export const signIn = (user, history) => {
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
    LocalStorageService.saveToLocal("transanUserID", "loggedout");
    return (dispatch) => {

      window.location.href="/"

        dispatch({ type: 'SIGNOUT_SUCCESS' })
      };

      
    }

    export const sSubmit =(aa) => {
      return (dispatch) => {          
        searchSubmit(aa).then(response => {
    
          if(response.data){
            dispatch({ type: 'searchSubmitSuccess' });
          }
          else  {
          dispatch({ type: 'searchSubmitUnSuccess' });
        }
    });
      }}
    
    
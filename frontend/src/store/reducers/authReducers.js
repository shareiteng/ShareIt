import LocalStorageService from "../../LocalStorageService";

const initState = {
    authError: null,
    auth:null
  }
  
  const authReducer=  (state = {
    auth : LocalStorageService.getFromLocal("transcanUserId") 
}, action)=> {
    switch(action.type){
      case 'LOGIN_ERROR':
       // console.log('login error');
     //   console.log( state);
        return {
          ...state,
          authError: 'Login failed'
        }
      case 'LOGIN_SUCCESS':
     // window.location.href="/search" 
     //LocalStorageService.saveToLocal("transanUserID", "transanUserID");
        return {
          ...state,
          auth: LocalStorageService.getFromLocal("transanUserID"),
          authError: null
        }

        case 'SIGNOUT_SUCCESS':
         console.log('signout success');
         LocalStorageService.removeFromLocal("transcanUserId");
          localStorage.clear();
        console.log (LocalStorageService.getFromLocal("transcanUserId"));
      //   window.location.href="/" 
         return {
          ...state,
          authError: null,
          auth: action.user
          }
         
        case 'SIGNUP_SUCCESS':
         window.alert("SignUp sucssesed, please Log In ");
            console.log('signup success')
         return {
        ...state,
        authError: null,
        
        }

  case 'SIGNUP_ERROR':
    console.log('signup error');
    return {
      ...state,
      authError: action.err.message
    }
    default:
    return state
}
  };
  
  export default authReducer;

const initState = {
    authError: null,
    auth:null
  }
  
  const authReducer = (state = initState, action) => {
    switch(action.type){
      case 'LOGIN_ERROR':
        console.log('login error');
        console.log( state);
        return {
          ...state,
          authError: 'Login failed'
        }
      case 'logged':
        console.log("kkk");
          return {
            ...state,
            auth:'login',
            authError: null
          }
          case 'unlogged':
            
              console.log("unlog");
              return {
                ...state,
                auth:null,
                authError: null
              }

      case 'LOGIN_SUCCESS':
      window.location.href="/search" 
      //console.log('login success'+ state);
        return {
          ...state,
          auth:'login',
          authError: null
        }

        case 'SIGNOUT_SUCCESS':
         console.log('signout success');
        // window.location.href="/" 
         return {
          ...state,
          authError: null,
          auth: null
          }
         
        case 'SIGNUP_SUCCESS':
            window.location.href="/search" 
            console.log('signup success');
          
         return {
        ...state,
        authError: null,
        auth: 'login'
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
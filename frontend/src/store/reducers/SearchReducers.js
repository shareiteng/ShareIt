const initState = {
    submitError: null,
   
  }

const searchReducer = (state = initState, action) => {
    switch(action.type){
      case 'SUBMIT_ERROR':
        console.log('submit error');

        return {
          ...state,
            submitError: "fail"
        }
    
        case 'SUBMIT_SUCCESS':
                console.log('login error');
                return {
                  ...state,
                }
            }
        }
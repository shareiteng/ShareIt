const initState = {
    submitError: null,
   
  }

const newDriveReducer = (state = initState, action) => {
    switch(action.type){
      case 'SUBMIT_ERROR':
        console.log('submit error');

        return {
          ...state,
            submitError: "fail"
        }
    
        case 'SUBMIT_SUCCESS':
                console.log('new drive update error');
                return {
                  ...state,
                }
            }
        }
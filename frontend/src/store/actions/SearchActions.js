

import LocalStorageService from '../../LocalStorageService';
import {searchSubmit} from '../../TranscanApi'
import{connect }from 'react-redux'


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
  }
}

    
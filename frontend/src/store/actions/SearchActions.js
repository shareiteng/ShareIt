import { searchSubmit } from "../../TranscanApi";

export const submit = (newride) => {
    return (dispatch) => {
      searchSubmit(newUser).then(response => {    
      } ).then(() => {
          dispatch({ type: 'SUBMIT_SUCCESS' });
        }).catch((err) => {
          dispatch({ type: 'SUBMIT_ERROR', err});
        });
      }
    }
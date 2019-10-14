import { sSubmit } from "../../TranscanApi";

export const searchSubmit = (newride) => {
    return (dispatch) => {
      sSubmit(newride).then(response => {    
      } ).then(() => {
          dispatch({ type: 'SUBMIT_SUCCESS' });
        }).catch((err) => {
          dispatch({ type: 'SUBMIT_ERROR', err});
        });
      }
    }
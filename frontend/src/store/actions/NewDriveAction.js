import { nDSubit } from "../../TranscanApi";

export const submit = (newDrive) => {
    return (dispatch) => {
        nDSubmit(newDrive).then(response => {    
      } ).then(() => {
          dispatch({ type: 'SUBMIT_SUCCESS' });
        }).catch((err) => {
          dispatch({ type: 'SUBMIT_ERROR', err});
        });
      }
    }
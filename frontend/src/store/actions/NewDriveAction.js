import { driverSubmit } from "../../TranscanApi";

export const submit = (newDrive) => {
    return (dispatch) => {
      driverSubmit(newDrive).then(response => {    
      } ).then(() => {
          dispatch({ type: 'SUBMIT_SUCCESS' });
        }).catch((err) => {
          dispatch({ type: 'SUBMIT_ERROR', err});
        });
      }
    }
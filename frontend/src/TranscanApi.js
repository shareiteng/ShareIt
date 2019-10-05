import axios from "axios";
import localStorageService from './LocalStorageService'

const api = "http://localhost:5000/api/auth"

// Generate a unique token for storing your bookshelf data on the backend server.
let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)


export const addNewUser = (query) =>
  axios.post(`${api}/signup`, query);

export  const login = (query) =>
  axios.post(`${api}/signin`,query );

export  const isLogin = (query) =>
   axios.post(`${api}/islogin`,query);

  export  const sSubmit = (query) =>
   axios.post(`${api}/searchsubmit`,query);

   export  const nDSubmit = (query) =>
   axios.post(`${api}/newDriveSubmit`,query);


  
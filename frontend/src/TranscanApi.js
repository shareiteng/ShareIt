import axios from "axios";

const api = "http://localhost:5000/api"

// Generate a unique token for storing your bookshelf data on the backend server.
let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)


export const addNewUser = (query) =>
  axios.post(`${api}/auth/signup`, query);

export  const login = (query) =>
  axios.post(`${api}/auth/signin`,query  
    );

export  const isLogin = (query) =>
   axios.post(`${api}/auth/islogin`,query  
    );

    export  const searchSubmit = (query) =>
    axios.post(`${api}/form_submit/searchsubmit`,query, {
      params: {
        userId: 2
      }} );

    
export  const driverSubmit = (query ) =>
axios.post(`${api}/form_submit/suggestionsubmit`,query, {
  params: {
    userId: 1
  }} );
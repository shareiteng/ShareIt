import axios from "axios";

const api = "http://localhost:8080/index"

// Generate a unique token for storing your bookshelf data on the backend server.
let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)


export const add = (query) =>
  axios.post(`${api}/addNewUser`, query);

export  const login = (query) =>
  axios.get(`${api}/login`,{
    params: 
      query
    })
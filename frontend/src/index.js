import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import authReducers from './store/reducers/authReducers'
import { createStore, combineReducers, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import thunkMiddleware from 'redux-thunk';
import SearchReducers from './store/reducers/SearchReducers'
import {loggedCheck} from './store/actions/AuthActions'

const store = createStore(authReducers, applyMiddleware(thunkMiddleware))
thunkMiddleware( loggedCheck());
store.dispatch( loggedCheck());
ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

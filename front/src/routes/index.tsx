import React from 'react';
import { Switch } from 'react-router-dom';

import Route from './Route';

import Home from '../pages/Home';
import Cliente from '../pages/Cliente';
import Login from '../pages/Login';


const Routes: React.FC = () => (
    <Switch>
        <Route path="/" exact component={Login} ></Route>
        <Route path="/home" component={Home} isPrivate ></Route>
        <Route path="/cadastrar-cliente" component={Cliente} isPrivate></Route>
    </Switch>
)

export default Routes;
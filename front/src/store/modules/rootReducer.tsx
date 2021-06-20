import { combineReducers } from 'redux';

import cliente from './cliente/reducer';
import auth from './auth/reducer';
import user from './user/reducer';

export default combineReducers({
  auth, user, cliente,
});

import { all } from 'redux-saga/effects';

import cliente from './cliente/sagas';
import auth from './auth/sagas';

export default function* rootSaga():any {
  return yield all([auth, cliente]);
}

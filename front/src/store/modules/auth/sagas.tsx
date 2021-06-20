import { takeLatest, call, put, all } from 'redux-saga/effects';

import { toast } from 'react-toastify';

import api from '../../../services';
import history from '../../../services/history';

import { signInSuccess, signFailure } from './actions';

export function* signIn({ payload }: any):any {
  try {
    const { username, password } = payload;
    // console.log('login:', payload)
    const response = yield call(api.post, '/api/auth/signin', {
      username,
      password,
    });

    if (!response) {
      toast.error('Usuário não encontrado.');
      return;
    }
// console.log('dados: ',response.data)
    const { token, roles } = response.data;

    const user = {
      name: username,
      roles 
    }

    api.defaults.headers.Authorization = `Bearer ${token}`;

    yield put(signInSuccess(token, user));

    history.push('home');

  } catch (error) {
    toast.error('Falha na autenticação, verifique seus dados.');
    yield put(signFailure());
  }
}

export function* signUp({ payload }: any):any {
  try {
    const { name, username, password } = payload;

    yield call(api.post, 'users', {
      name,
      username,
      password,
      provider: true,
    });
    toast.info('Usuário cadastrado com sucesso!');

  } catch (error) {
    toast.error('Falha no cadastro, verifique seus dados.');

    yield put(signFailure());
  }
}

export function setToken({ payload }: any):any  {
  if (!payload) return;

  const { token } = payload.auth;

  if (token) {
    api.defaults.headers.Authorization = `Bearer ${token}`;
  }
}

export function signOut() {
  history.push('/');
}

export default all([
  takeLatest('persist/REHYDRATE', setToken),
  takeLatest('@auth/SIGN_IN_REQUEST', signIn),
  takeLatest('@auth/SIGN_UP_REQUEST', signUp),
  takeLatest('@auth/SIGN_OUT', signOut),
]);

import { takeLatest, call, put, all } from 'redux-saga/effects';
import { toast } from 'react-toastify';

import api from '../../../services';

import {
  createSuccess,
  createFailure,
  deleteSuccess,
  deleteFailure,
  listSuccess,
  listFailure,
} from './actions';

export function* create({ payload }: any):any {
  try {
    const { id, nome, cpf, endereco} = payload;
    console.log('create:', payload)
    if (id) {
      const response = yield call(api.put, `clientes/${id}`, {
        nome, cpf, endereco 
      });

      if (!response) {
        toast.error('Erro ao atualizar.');
        return;
      }

      yield put(createSuccess(response.data));
      toast.success('Atualizado com sucesso.');
    } else {
      const response = yield call(api.post, 'clientes', {
        nome, cpf, endereco
      });

      if (!response) {
        toast.error('Erro ao inserir.');
        return;
      }

      yield put(createSuccess(response.data));

      toast.success('Cadastrado com sucesso.');
    }
  } catch (error) {
    toast.error('Falha ao cadastrar.');
    yield put(createFailure());
  }
}

export function* excluir({ payload }: any): any {
  try {
    const { id } = payload;

    const response = yield call(api.delete, `clientes/${id}`);

    if (!response) {
      toast.error('Erro ao excluir.');
      return;
    }

    yield put(deleteSuccess(response.data));

    toast.success('Excluído com sucesso.');
  } catch (error) {
    toast.error('Falha ao excluir.');
    yield put(deleteFailure());
  }
}

export function* listar():any {
  try {
  
      const response = yield call(api.get, 'clientes');

      if (!response) {
        toast.error('Erro ao listar.');
        return;
      }

      yield put(listSuccess(response.data));

  } catch (error) {
    toast.error('Falha ao listar clientes.');
    yield put(listFailure());
  }
}

export default all([
  takeLatest('@clientes/CREATE_REQUEST', create),
  takeLatest('@clientes/DELETE_REQUEST', excluir),
  takeLatest('@clientes/LIST_REQUEST', listar),
]);

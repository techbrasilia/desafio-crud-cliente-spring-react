import produce from 'immer';

const INITIAL_STATE = {
  cliente: null,
  retorno: null,
};

export default function clientes(state = INITIAL_STATE, action:any) {
  // console.log('dataas state:', state)
  // console.log('dataas action:', action)
  return produce(state, (draft) => {
    switch (action.type) {
      case '@clientes/CREATE_REQUEST': {
        draft.cliente = action.payload;

        break;
      }
      case '@clientes/CREATE_SUCCESS': {
        draft.cliente = action.payload.clientes;
        break;
      }
      case '@clientes/CREATE_FAILURE': {
        break;
      }

      case '@clientes/DELETE_REQUEST': {
        draft.cliente = action.payload;
        break;
      }
      case '@clientes/DELETE_SUCCESS': {
        draft.retorno = action.payload;
        break;
      }

      case '@clientes/LIST_REQUEST': {
        draft.retorno = action.payload;
        break;
      }

      default:
    }
  });
}

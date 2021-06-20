import storage from 'redux-persist/lib/storage';
import { persistReducer } from 'redux-persist';

// eslint-disable-next-line import/no-anonymous-default-export
export default (reducers:any) => {
  const persistedReducer = persistReducer(
    {
      key: 'desafio_crud_cliente_fabio',
      storage,
      whitelist: ['auth', 'user', 'cliente'],
    },
    reducers
  );

  return persistedReducer;
};

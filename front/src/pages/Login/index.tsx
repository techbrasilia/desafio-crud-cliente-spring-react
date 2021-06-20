import React from 'react';
import { useDispatch } from 'react-redux';

import { Form, Input } from '@rocketseat/unform';

import { signInRequest } from '../../store/modules/auth/actions';

import { Container, Formulario } from './styles'

const Login: React.FC = () => {
  const dispatch = useDispatch();

  function handleSubmit({ username, password }:any):any {
    dispatch(signInRequest(username, password));
  }
  return (
    <Container>
      <Formulario>
        <Form onSubmit={handleSubmit}>
          <label>Usuário</label>
          <Input type="text" name="username" placeholder="" />
          <label>Senha</label>
          <Input type="password" name="password" placeholder="******" />
          <button type="submit">Entrar</button>
        </Form>
      </Formulario>
    </Container>
  );
}
export default Login;
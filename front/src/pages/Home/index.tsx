import React,  { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { MdAdd } from 'react-icons/md';
import { useDispatch } from 'react-redux';

import api from '../../services';
import Cliente from '../../interface/Cliente';
import { signOut } from '../../store/modules/auth/actions';
import { store } from '../../store';


import { Container, Table, Linha } from './styles';

const Home: React.FC = () => {
    const [clientes, setClientes] = useState<Cliente[]>([]);
    const dispatch = useDispatch();

    const auth:any = store.getState();
    const { token }:any = auth.auth;

    
    useEffect(() => {
        async function listarClientes() {
            const header = {
                headers: { 
                    Authorization: `Bearer ${token}`
                }
            };
            console.log('headers: ',header)
            const response = await api.get('clientes', header);
            setClientes(response.data);
        }
        listarClientes();
    },[]);

    function handleSignOut() {
        dispatch(signOut());
      }

    return (
        <Container>
            <h1>Clientes</h1>
            <Table>
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Cidade</th>
                    <th>UF</th>
                </tr>
                </thead>
                <tbody>
                    {clientes.map(cliente => (
                        <Linha key={cliente.id}>
                            <td>{cliente.nome}</td>
                            <td>{cliente.cpf}</td>
                            <td>{cliente.endereco?.localidade}</td>
                            <td>{cliente.endereco.uf}</td>
                        </Linha>
                    ))}

                </tbody>
            </Table>
            <footer>
                <Link to="/cadastrar-cliente">
                    <MdAdd color="#fff" size={20} />
                    <span>Novo Cliente</span>
                </Link>
                <div>
                <button type="button" onClick={handleSignOut}>
                    Sair do sistema
                </button>
                </div>
            </footer>
        </Container>
    )
};

export default Home;
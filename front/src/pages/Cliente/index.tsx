import React,{ useEffect, useState }  from 'react';
import { Link } from 'react-router-dom';
import { MdArrowBack, MdCheck } from 'react-icons/md';
import { Form } from '@unform/web';
import { useDispatch } from 'react-redux';

import Input from '../../components/Input'
import ClienteInterface from '../../interface/Cliente';
import { createRequest } from '../../store/modules/cliente/actions';

import { Container, Content } from './styles';
import history from '../../services/history';

interface EnderecoInterface{
    "cep": string,
    "logradouro": string,
    "complemento": string,
    "bairro": string,
    "localidade": string,
    "uf": string,
    "ibge": string,
    "gia": string,
    "ddd": string,
    "siafi":string
  }

const Cliente: React.FC = () => {
    const [endereco, setEndereco] = useState<EnderecoInterface | null>();
    const [cliente, setCliente] = useState<ClienteInterface | null>();
    const [search, setSearch] = useState('');
    const [error, setError] = useState(false);
    const dispatch = useDispatch();
    

    useEffect(() => {
        function buscaPorCep() {
            fetch(`https://viacep.com.br/ws/${search}/json/`)
            .then(response => response.json())
            .then(data => {
                setEndereco(data);
                setError(false);
                console.log('endereco:', endereco)
            })
            .catch(err => {
                setError(true);
            })
        }

        if(search != null && search.length >= 8) {
            buscaPorCep();
        }else{
            setEndereco(null);
        }

    },[search]);

    function handleSearch(s:any) {
        setSearch(s.target.value);
    }


    async function handleSubmit(data:ClienteInterface) {
        
        dispatch(createRequest(data));
      }

    function handleGoBack() {
    history.back();
    }

    return (
        <Container>
            <Content>
                
                <h1>Cadastro de Cliente</h1>
                <Form onSubmit={handleSubmit}>
                <div>
                    <div>
                        <label>Nome</label>
                        <Input type="text" name="nome" />
                    </div>
                    <div>
                        <label>CPF</label>
                        <Input type="text" name="cpf" />
                    </div>
                    <div>
                        <label>CEP</label>
                        <Input type="text" name="endereco.cep" 
                        value={search}
                        onChange={handleSearch}/>
                    </div>
                    <div>
                        <label>logradouro</label>
                        <Input type="text" name="endereco.logradouro" value={endereco?.logradouro || null}/>
                    </div>
                    <div>
                        <label>bairro</label>
                        <Input type="text" name="endereco.bairro" value={endereco?.bairro || null} />
                    </div>
                    <div>
                        <label>cidade</label>
                        <Input type="text" name="endereco.cidade" value={endereco?.localidade || null} />
                    </div>
                    <div>
                        <label>Complemento</label>
                        <Input type="text" name="endereco.complemento" value={endereco?.complemento || null} />
                    </div>
                    <div>
                        <label>uf</label>
                        <Input type="text" name="endereco.uf" value={endereco?.uf || null} />
                    </div>
                </div>
                <footer>
                    <div>
                        <Link to="#" onClick={handleGoBack}>
                            <MdArrowBack color="#fff" size={20} />
                            <span>Voltar</span>
                        </Link>
                        <button type="submit">
                            <MdCheck color="#fff" size={20} />
                            <span>Salvar</span>
                        </button>
                    </div>
                </footer>
                </Form>
            </Content>
        </Container>
    )
};

export default Cliente;
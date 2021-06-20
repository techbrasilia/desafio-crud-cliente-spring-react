import Email from '../Email/Email';
import Telefone from '../Telefone';

interface ClienteInterface {
    id: number,
    nome: string,
    cpf: string,
    endereco: {
        id: number,
        cep: string,
        logradouro: string,
        bairro: string,
        cidade: string,
        uf: string,
    },
    telefones: Telefone[],
    emails: Email[]
    
}
export default ClienteInterface;
import Email from '../Email/Email';
import EnderecoInterface from '../Endereco';
import Telefone from '../Telefone';

interface ClienteInterface {
    id: number,
    nome: string,
    cpf: string,
    endereco: EnderecoInterface,
    telefones: Telefone[],
    emails: Email[]
    
}
export default ClienteInterface;
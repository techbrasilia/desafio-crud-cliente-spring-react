import ClienteInterface from '../../../interface/Cliente';

export function createRequest(data:ClienteInterface) {
  
    return {
      type: '@clientes/CREATE_REQUEST',
      payload: {
        id: data.id ? data.id : null,
        nome: data.nome,
        cpf: data.cpf,
        endereco: {
          cep: data.endereco.cep,
          logradouro: data.endereco.logradouro,
          bairro: data.endereco.bairro,
          localidade: data.endereco.localidade,
          uf: data.endereco.uf,
        }
      },
    };
  }
  
  export function createSuccess(cliente:any) {
    return {
      type: '@clientes/CREATE_SUCCESS',
      payload: { cliente },
    };
  }
  
  export function createFailure() {
    return {
      type: '@clientes/CREATE_FAILURE',
    };
  }
  
  export function deleteRequest(id:number) {
    return {
      type: '@clientes/DELETE_REQUEST',
      payload: { id },
    };
  }
  
  export function deleteSuccess(data:any) {
    return {
      type: '@clientes/DELETE_SUCCESS',
      payload: { data },
    };
  }
  
  export function deleteFailure() {
    return {
      type: '@clientes/DELETE_FAILURE',
    };
  }

  export function listRequest() {
  
    return {
      type: '@clientes/LIST_REQUEST',
    };
  }

  export function listSuccess(clientes: ClienteInterface[]) {
    return {
      type: '@clientes/LIST_SUCCESS',
      payload: { clientes },
    };
  }

  export function listFailure() {
    return {
      type: '@clientes/CREATE_FAILURE',
    };
  }
 
  
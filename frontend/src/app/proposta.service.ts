import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable()
export class PropostaService {

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[] > (`${this.url}` + '/proposta/listar');
  }

  salvar(proposta) {
    console.log(proposta);
    return this.http.post(`${this.url}` + '/proposta/cadastrar', proposta);
  }

  buscarPorCpf(cpf) {
    return this.http.get(`${this.url}` + '/proposta/porCpf/' + cpf);
  }
}

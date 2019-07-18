import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PropostaService} from "../../proposta.service";

@Component({
  selector: 'app-pesquisar',
  templateUrl: './pesquisar.component.html',
  styleUrls: ['./pesquisar.component.css']
})
export class PesquisarComponent implements OnInit {

  @Output() retornarProposta= new EventEmitter<object>();

  cpf: String = '';

  constructor( private propostaService: PropostaService) { }

  ngOnInit() {
  }

  proposta: object;

  pesquisarPorCpf() {
    if (this.cpf.trim()) {
      this.propostaService.buscarPorCpf(this.cpf.trim()).subscribe(proposta => {
        this.proposta = proposta;
        this.retornarProposta.emit(proposta);
        this.cpf = '';
      });
    } else {
      this.retornarProposta.emit(null);
    }
  }
  feedback(){
    this.retornarProposta.emit(this.proposta);
  }
}

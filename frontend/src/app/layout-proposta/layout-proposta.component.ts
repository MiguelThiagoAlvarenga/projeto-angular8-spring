import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {PropostaService} from "../proposta.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NgbModalBackdrop} from '@ng-bootstrap/ng-bootstrap/modal/modal-backdrop';
import {ViewEncapsulation} from "@angular/cli/lib/config/schema";
import {PesquisarComponent} from "./pesquisar/pesquisar.component";

// @ts-ignore
let viewChild = ViewChild(PesquisarComponent);

@Component({
  selector: 'app-layout-proposta',
  templateUrl: './layout-proposta.component.html',
  styleUrls: ['./layout-proposta.component.css'],
  encapsulation: ViewEncapsulation.None,
  styles: [`
    .dark-modal .modal-content {
      background-color: #292b2c;
      color: white;
    }
    .dark-modal .close {
      color: white;
    }
    .light-blue-backdrop {
      background-color: #5cb3fd;
    }
  `]
})
export class LayoutPropostaComponent implements OnInit {

  @viewChild pesquisaRetorno;

  listaPropostas: Array<any>;

  proposta: {
    id: null,
    cliente: {
      id: null,
      nome: '',
      cpf: '',
      idade: null,
      sexo: '',
      estado: '',
      dependentes: null,
      renda: '',
      estado_civil: ''
    }
  };

  closeResult: string;

  constructor( private propostaService: PropostaService, private modalService: NgbModal ) { }

  ngOnInit() {
    this.listar()
  }

  reciverFeedback(proposta) {
    if (proposta) {
      this.limparCad();
      this.listaPropostas = [];
      this.listaPropostas.push(proposta);
    } else {
      this.listar();
    }
  }
  listar(){
    this.propostaService.listar().subscribe(propostas => {
      this.listaPropostas = propostas
    } );
  }

  limparCad() {
    this.proposta = {
      id: null,
      cliente: {
        id: null,
        nome: '',
        cpf: '',
        idade: null,
        sexo: '',
        estado: '',
        dependentes: null,
        renda: '',
        estado_civil: ''
      }
    };
  }

  openXl(content) {
    this.modalService.open(content, {size: 'xl'});
  }
}

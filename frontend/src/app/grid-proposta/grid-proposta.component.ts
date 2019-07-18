import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-grid-proposta',
  templateUrl: './grid-proposta.component.html',
  styleUrls: ['./grid-proposta.component.css']
})
export class GridPropostaComponent implements OnInit {

  @Input() propostas: Array<any>;

  listPropostas: Array<any>;

  constructor() { }

  ngOnInit() { }
}

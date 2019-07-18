import {Component, Input, OnInit} from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {ViewEncapsulation} from "@angular/cli/lib/config/schema";
import {PropostaService} from "../../../proposta.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {IgnoredDependency} from "@angular/compiler-cli/ngcc/src/dependencies/dependency_resolver";

@Component({
  selector: 'app-cad-proposta',
  templateUrl: './cad-proposta.component.html',
  styleUrls: ['./cad-proposta.component.css'],
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
export class CadPropostaComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;

  @Input() proposta: object;

  closeResult: string;

  constructor(private modalService: NgbModal, private propostaService: PropostaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      sexo: ['', Validators.required],
      nome: ['', Validators.required],
      cpf: ['', Validators.required],
      idade: ['', Validators.required],
      estado: ['',Validators.required],
      dependentes: ['', Validators.required],
      estado_civil: ['', Validators.required],
      renda: ['', Validators.required]
    });
  }
  openXl(content) {
    this.modalService.open(content, {size: 'xl'});
  }

  salvar() {
    const proposta = {
        cliente: {
          nome: this.registerForm.value.nome,
          cpf: this.registerForm.value.cpf,
          idade: this.registerForm.value.idade,
          sexo: this.registerForm.value.sexo,
          estado: this.registerForm.value.estado,
          dependentes: this.registerForm.value.dependentes,
          renda: this.registerForm.value.renda,
          estadoCivil: {id: parseInt(this.registerForm.value.estado_civil)}
        },
        resultadoAnalise:'EmAnalise',
        aproaprovada: false,
        limiteCred: {id: 1}

      }

    this.propostaService.salvar(proposta).subscribe(proposta => {
      this.onReset();
      this.modalService.dismissAll('Cross click');
    },
    error => {
      Error('Erro ao enviar a proposta');
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    this.salvar();

  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
    this.modalService.dismissAll('Cross click');
  }

  DECIMAL_SEPARATOR=".";
  GROUP_SEPARATOR=",";
  pureResult: any;
  maskedId: any;
  val: any;
  v: any;

  format(valString) {
    if (!valString) {
      return '';
    }
    let val = valString.toString();
    const parts = this.unFormat(val).split(this.DECIMAL_SEPARATOR);
    this.pureResult = parts;
    if (parts[0].length <= 11) {
      this.maskedId = this.cpf_mask(parts[0]);
      return this.maskedId;
    } else {
      this.maskedId = this.cnpj(parts[0]);
      return this.maskedId;
    }
  }


  unFormat(val) {
    if (!val) {
      return '';
    }
    val = val.replace(/\D/g, '');

    if (this.GROUP_SEPARATOR === ',') {
      return val.replace(/,/g, '');
    } else {
      return val.replace(/\./g, '');
    }
  };

  cpf_mask(v) {
    v = v.replace(/\D/g, ''); //Remove tudo o que não é dígito
    v = v.replace(/(\d{3})(\d)/, '$1.$2'); //Coloca um ponto entre o terceiro e o quarto dígitos
    v = v.replace(/(\d{3})(\d)/, '$1.$2'); //Coloca um ponto entre o terceiro e o quarto dígitos
    //de novo (para o segundo bloco de números)
    v = v.replace(/(\d{3})(\d{1,2})$/, '$1-$2'); //Coloca um hífen entre o terceiro e o quarto dígitos
    return v;
  }

  cnpj(v) {
    v = v.replace(/\D/g, ''); //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/, '$1.$2'); //Coloca ponto entre o segundo e o terceiro dígitos
    v = v.replace(/^(\d{2})\.(\d{3})(\d)/, '$1.$2.$3'); //Coloca ponto entre o quinto e o sexto dígitos
    v = v.replace(/\.(\d{3})(\d)/, '.$1/$2'); //Coloca uma barra entre o oitavo e o nono dígitos
    v = v.replace(/(\d{4})(\d)/, '$1-$2'); //Coloca um hífen depois do bloco de quatro dígitos
    return v;
  }
}

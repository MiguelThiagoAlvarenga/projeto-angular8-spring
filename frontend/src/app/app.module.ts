import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { GridPropostaComponent } from './grid-proposta/grid-proposta.component';
import { HeaderComponent } from './header/header.component';
import { PropostaService } from './proposta.service';
import { LayoutPropostaComponent } from './layout-proposta/layout-proposta.component';
import { CadPropostaComponent } from './layout-proposta/cadastro/cad-proposta/cad-proposta.component';
import {
  NgbPaginationModule,
  NgbAlertModule,
  NgbModule
} from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './layout-proposta/footer/footer.component';
import { PesquisarComponent } from './layout-proposta/pesquisar/pesquisar.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    GridPropostaComponent,
    HeaderComponent,
    LayoutPropostaComponent,
    CadPropostaComponent,
    FooterComponent,
    PesquisarComponent
  ],
  imports: [
    NgbPaginationModule,
    NgbAlertModule,
    BrowserModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    PropostaService
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    HeaderComponent,
    FooterComponent
  ],
})
export class AppModule { }

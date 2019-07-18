import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadPropostaComponent } from './cad-proposta.component';

describe('CadPropostaComponent', () => {
  let component: CadPropostaComponent;
  let fixture: ComponentFixture<CadPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

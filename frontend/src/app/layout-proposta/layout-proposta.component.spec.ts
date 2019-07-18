import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutPropostaComponent } from './layout-proposta.component';

describe('LayoutPropostaComponent', () => {
  let component: LayoutPropostaComponent;
  let fixture: ComponentFixture<LayoutPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LayoutPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LayoutPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

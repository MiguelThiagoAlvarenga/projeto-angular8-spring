import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GridPropostaComponent } from './grid-proposta.component';

describe('GridPropostaComponent', () => {
  let component: GridPropostaComponent;
  let fixture: ComponentFixture<GridPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GridPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GridPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriacaoAgendamentoComponent } from './criacao-agendamento.component';

describe('CriacaoAgendamentoComponent', () => {
  let component: CriacaoAgendamentoComponent;
  let fixture: ComponentFixture<CriacaoAgendamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriacaoAgendamentoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CriacaoAgendamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

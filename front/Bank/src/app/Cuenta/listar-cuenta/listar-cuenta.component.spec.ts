import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCuentaComponent } from './listar-cuenta.component';

describe('ListarCuentaComponent', () => {
  let component: ListarCuentaComponent;
  let fixture: ComponentFixture<ListarCuentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarCuentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarCuentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

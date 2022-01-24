import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleterUsuarioComponent } from './deleter-usuario.component';

describe('DeleterUsuarioComponent', () => {
  let component: DeleterUsuarioComponent;
  let fixture: ComponentFixture<DeleterUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleterUsuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleterUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

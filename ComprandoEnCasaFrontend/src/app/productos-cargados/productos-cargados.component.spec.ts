import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductosCargadosComponent } from './productos-cargados.component';

describe('ProductosCargadosComponent', () => {
  let component: ProductosCargadosComponent;
  let fixture: ComponentFixture<ProductosCargadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductosCargadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductosCargadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

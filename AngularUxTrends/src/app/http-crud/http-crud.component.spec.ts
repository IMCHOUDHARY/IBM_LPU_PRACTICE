import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpCRUDComponent } from './http-crud.component';

describe('HttpCRUDComponent', () => {
  let component: HttpCRUDComponent;
  let fixture: ComponentFixture<HttpCRUDComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HttpCRUDComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HttpCRUDComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

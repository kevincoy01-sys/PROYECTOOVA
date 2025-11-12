import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OvaCatalog } from './ova-catalog';

describe('OvaCatalog', () => {
  let component: OvaCatalog;
  let fixture: ComponentFixture<OvaCatalog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OvaCatalog]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OvaCatalog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaptchasComponent } from './captchas.component';

describe('CaptchasComponent', () => {
  let component: CaptchasComponent;
  let fixture: ComponentFixture<CaptchasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CaptchasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CaptchasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

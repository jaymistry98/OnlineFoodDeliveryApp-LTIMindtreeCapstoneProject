import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFoodItemComponent } from './edit-food-item.component';

describe('EditFoodItemComponent', () => {
  let component: EditFoodItemComponent;
  let fixture: ComponentFixture<EditFoodItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditFoodItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditFoodItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

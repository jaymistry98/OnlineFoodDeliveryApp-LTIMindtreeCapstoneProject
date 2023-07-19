import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EditFoodItemComponent } from './edit-food-item.component';
@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: EditFoodItemComponent }]),
  ],
})
export class EditFoodItemModule {}

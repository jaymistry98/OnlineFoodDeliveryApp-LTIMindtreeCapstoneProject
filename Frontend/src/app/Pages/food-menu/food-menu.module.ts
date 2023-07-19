import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { FoodMenuComponent } from './food-menu.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: FoodMenuComponent }]),
  ],
})
export class FoodMenuModule {}

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { EditOffersComponent } from './edit-offers.component';
@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: EditOffersComponent }]),
  ],
})
export class EditOffersModule {}

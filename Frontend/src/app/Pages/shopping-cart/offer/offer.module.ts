import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OfferComponent } from './offer.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: OfferComponent }]),
  ],
})
export class OfferModule {}

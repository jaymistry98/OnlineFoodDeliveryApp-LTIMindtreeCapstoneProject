import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ShoppingCartComponent } from './shopping-cart.component';
import { OfferComponent } from './offer/offer.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: ShoppingCartComponent }]),
  ],
  declarations: [
  ],
})
export class ShoppingCartModule {}

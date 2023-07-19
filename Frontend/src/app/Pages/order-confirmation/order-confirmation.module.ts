import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OrderConfirmationComponent } from './order-confirmation.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: OrderConfirmationComponent }]),
  ],
})
export class OrderConfirmationModule {}

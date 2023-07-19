import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { VendorDashboardComponent } from './vendor-dashboard.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: VendorDashboardComponent }]),
  ],
})
export class VendorDashboardModule {}

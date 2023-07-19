import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { VendorRegisterComponent } from './vendor-register.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: VendorRegisterComponent }]),
  ],
})

export class VendorRegisterModule {}

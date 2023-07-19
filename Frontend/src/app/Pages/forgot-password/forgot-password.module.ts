import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ForgotPasswordComponent } from './forgot-password.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: ForgotPasswordComponent }]),
  ],
})
export class ForgotPasswordModule {}

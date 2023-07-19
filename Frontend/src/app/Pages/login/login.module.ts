import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: LoginComponent }]),
  ],
})
export class LoginModule {}

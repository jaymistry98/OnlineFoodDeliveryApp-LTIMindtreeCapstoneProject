import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: RegisterComponent }]),
  ],
})
export class RegisterModule {}

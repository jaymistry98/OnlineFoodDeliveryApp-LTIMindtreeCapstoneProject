import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UserDashboardComponent } from './user-dashboard.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: UserDashboardComponent }]),
  ],
})
export class UserDashboardModule {}

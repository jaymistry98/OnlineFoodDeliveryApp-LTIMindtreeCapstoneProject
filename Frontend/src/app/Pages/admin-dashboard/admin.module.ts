import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AdminDashboardComponent } from './admin-dashboard.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: AdminDashboardComponent }]),
  ],
})
export class AdminModule {}

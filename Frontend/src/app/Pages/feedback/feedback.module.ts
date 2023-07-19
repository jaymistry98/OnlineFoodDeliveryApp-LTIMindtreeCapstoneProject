import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { FeedbackComponent } from './feedback.component';

@NgModule({
  imports: [
    RouterModule.forChild([{ path: '', component: FeedbackComponent }]),
  ],
})
export class FeedbackModule {}

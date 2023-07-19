import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';
import { FeedbackService } from 'src/app/Services/feedback.service';
import { ShoppingCartService } from 'src/app/Services/shopping-cart.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  constructor(private fs: FeedbackService, private as: AuthService, private cs: ShoppingCartService,
    private router: Router) { }

  //Holds data for all feedbacks
  feedbackData: any[];

  //Form for submitting feedback
  feedbackForm: FormGroup;

  //rating input
  rating: FormControl;

  //description input
  description: FormControl;

  ngOnInit() { 
    this.createFormControls();
    this.createForm();

    //Do not display shopping cart icon
    this.as.authenticate(false);

    //clear the cart
    this.cs.removeAllCart();
  }

  createForm() {
    this.feedbackForm = new FormGroup({
      rating: this.rating,
      description: this.description,
    })
  }

  createFormControls() {
    this.rating = new FormControl('', Validators.required);
    this.description = new FormControl('', Validators.required);
  }

  //Submit a feedback
  createFeedback(){
    this.fs.createFeedback(this.feedbackForm.value).subscribe((response) => {
      this.as.authenticate(true);
      this.router.navigate(['/user-dashboard']);
    });
  }

  //Get all feedbacks
  loadFeedbacks() {
    this.fs.getAllFeedback().subscribe((data) => {
      const locArray = [];
      for(let key in data){
        locArray.push(data[key]);
      }
      this.feedbackData = locArray;
    });
  }
  
}

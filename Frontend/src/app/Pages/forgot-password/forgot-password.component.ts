import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Component } from '@angular/core';
import { UserService } from 'src/app/Services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {
  constructor(private us: UserService, private _router: Router) {}

   //Forgot password form
   forgotPassForm: FormGroup;
   email:FormControl;
   userName: FormControl;
   securityQuestion: FormControl;
   answer: FormControl;
   password: FormControl;

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  createForm() {
    this.forgotPassForm = new FormGroup({
      email: this.email,
      userName: this.userName,
      securityQuestion: this.securityQuestion,
      answer: this.answer,
      password: this.password
    });
  }

  createFormControls() {
    this.email = new FormControl('', [Validators.email, Validators.required]);
    this.userName = new FormControl('', Validators.required);
    this.securityQuestion = new FormControl('', Validators.required);
    this.answer = new FormControl('', Validators.required);
    this.password = new FormControl('', [Validators.required, Validators.minLength(6)])
  }

  //Change password and update in database
  changePassword() {
    console.log(this.forgotPassForm.value);
    this.us.changePassword(this.forgotPassForm.value).subscribe((response) => {
      this._router.navigate(['/login']);
    });
  }
}

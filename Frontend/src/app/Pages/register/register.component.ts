import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/Services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private us: UserService, private _router: Router) {}

  //Holds user information
  user: any;

  //Register form
  registerForm: FormGroup;
  email: FormControl;
  userName: FormControl;
  password: FormControl;
  securityQuestion: FormControl;
  answer: FormControl;
  type: FormControl;

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  createForm() {
    this.registerForm= new FormGroup({
      email: this.email,
      userName: this.userName,
      password: this.password,
      securityQuestion: this.securityQuestion,
      answer: this.answer,
      type: this.type
    });
  }

  createFormControls() {
    this.userName = new FormControl('', Validators.required);
    this.email = new FormControl('', [Validators.required, Validators.email]);
    this.password = new FormControl('', [Validators.required, Validators.minLength(6)]);
    this.securityQuestion = new FormControl('', Validators.required);
    this.answer = new FormControl('', Validators.required);
    this.type = new FormControl('', Validators.required);
  }

  register() {
    this.us.register(this.registerForm.value).subscribe((response) => {

      //Hold user information
      this.user = JSON.parse(JSON.stringify(response));

      //If type vendor, router to vendor register page, else login page
      if(this.user['type'].match(/^Vendor/)) {
        this._router.navigate(['/vendor-register', this.user.userId]);
      }
      else {
        this._router.navigate(['/login']);
      }

    });
  }

}

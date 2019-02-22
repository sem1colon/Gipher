import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { AccountManagerService } from '../../account-manager.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  errorMessage: any;
  successMessage: any;
  signupForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.maxLength(70)]),
    userId: new FormControl('', [Validators.required, Validators.maxLength(70)]),
    password: new FormControl('', [Validators.required, Validators.maxLength(70), Validators.minLength(6)]),
    repeatPassword: new FormControl('', [Validators.required, Validators.maxLength(30), Validators.minLength(6)]),
  });
  constructor(private service: AccountManagerService) { }

  ngOnInit() {
  }
  get form() { return this.signupForm.controls; }
  signup() {
    if ((this.signupForm.get('repeatPassword').value) == (this.signupForm.get('password').value)) {
      this.service.registerUser(this.signupForm.value)
        .subscribe(data => {
          if (data=="Signup successful!") {
            this.signupForm.reset();
            this.successMessage = data;
            this.errorMessage = null;
          } else {
            this.errorMessage = data;
            this.successMessage = null;
          }
        },
          error => {
            console.log(error);
            this.errorMessage = error.error;
          }
        )
    }
    else {
      this.errorMessage = "Password didn't matched, Please try again!";
    }
  }
}

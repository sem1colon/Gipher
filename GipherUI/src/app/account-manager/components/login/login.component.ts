import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { AccountManagerService } from '../../account-manager.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginStatus: any;
  errorMessage: any;
  loginForm = new FormGroup({
    userId: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });
  constructor(private service: AccountManagerService, private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }
  login() {
    this.service.loginUser(this.loginForm.value).subscribe(data => {
      if (data['token']) {
        this.authService.setToken(data['token']);
        this.authService.loginStatus = true;
        this.router.navigate(['home']);
      }
    }, error => {
      this.errorMessage = error.error;
    });
  }
}

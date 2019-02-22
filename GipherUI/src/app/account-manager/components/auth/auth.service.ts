import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loginStatus: boolean;
  token: string;
  constructor() { }
  login() {
    this.loginStatus = true;
  }
  logout() {
    this.loginStatus = false;
  }
  public isAuthenticated(): boolean {
    return this.loginStatus;
  }
  setToken(token: string) {
    this.token = token;
  }
  getToken(): string {
    return this.token;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountManagerService {
  accountManagerServiceEndpoint: string = "http://localhost:9001/api/v1/userservice";
  constructor(private http: HttpClient) { }
  registerUser(newUser) {
    const url = `${this.accountManagerServiceEndpoint}/signup`;
    return this.http.post(url, newUser, { responseType: 'text' });
  }

  loginUser(user): Observable<any> {
    const url = `${this.accountManagerServiceEndpoint}/login`;
    return this.http.post(url, user);
  }
}

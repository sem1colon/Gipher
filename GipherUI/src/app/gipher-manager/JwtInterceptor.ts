import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../account-manager/components/auth/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let token = this.authService.getToken();
        const re = 'https://api.giphy.com/v1/gifs/';
        if (request.url.search(re) === -1) {
            if (token) {
                console.log("Sending Token in Header", token);
                return next.handle(
                    request.clone({
                        headers: request.headers.append('authorization', `Bearer ${token}`)
                    })
                );
            }
        }
        return next.handle(request);
    }
}

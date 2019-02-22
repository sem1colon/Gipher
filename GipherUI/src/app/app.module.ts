import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './account-manager/components/login/login.component';
import { SignupComponent } from './account-manager/components/signup/signup.component';
import { DashboardComponent } from './gipher-manager/components/dashboard/dashboard.component';
import { FavouritesComponent } from './gipher-manager/components/favourites/favourites.component';
import { NavbarComponent } from './miscellaneous/components/navbar/navbar.component';
import { BookmarksComponent } from './gipher-manager/components/bookmarks/bookmarks.component';
import { ErrorComponent } from './miscellaneous/components/error/error.component';
import { JwtInterceptor } from './gipher-manager/JwtInterceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    DashboardComponent,
    FavouritesComponent,
    NavbarComponent,
    BookmarksComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

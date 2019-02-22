import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { By, BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { BookmarksComponent } from './gipher-manager/components/bookmarks/bookmarks.component';
import { NavbarComponent } from './miscellaneous/components/navbar/navbar.component';
import { FavouritesComponent } from './gipher-manager/components/favourites/favourites.component';
import { DashboardComponent } from './gipher-manager/components/dashboard/dashboard.component';
import { SignupComponent } from './account-manager/components/signup/signup.component';
import { LoginComponent } from './account-manager/components/login/login.component';


describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        LoginComponent,
        SignupComponent,
        DashboardComponent,
        FavouritesComponent,
        NavbarComponent,
        BookmarksComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule
      ],
      providers: [
        { provide: APP_BASE_HREF, useValue: "/" }
      ],
    })

      .compileComponents();
  }));
  beforeEach(() => {

  });
  // it('should create the app', () => {
  //   // const fixture = TestBed.createComponent(AppComponent);
  //   // const app = fixture.debugElement.componentInstance;
  //   // expect(app).toBeTruthy();
  // });

  // it(`should have as title 'GipherUI'`, () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   expect(app.title).toEqual('Gipher');
  // });

});

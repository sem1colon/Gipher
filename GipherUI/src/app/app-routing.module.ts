import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './gipher-manager/components/dashboard/dashboard.component';
import { AuthGuard } from './account-manager/components/auth/auth.guard';
import { LoginComponent } from './account-manager/components/login/login.component';
import { SignupComponent } from './account-manager/components/signup/signup.component';
import { BookmarksComponent } from './gipher-manager/components/bookmarks/bookmarks.component';
import { FavouritesComponent } from './gipher-manager/components/favourites/favourites.component';
import { ErrorComponent } from './miscellaneous/components/error/error.component';

const routes: Routes = [
  { path: "", canActivate: [AuthGuard], component: DashboardComponent },
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent },
  { path: "bookmarks", canActivate: [AuthGuard], component: BookmarksComponent },
  { path: "favs", canActivate: [AuthGuard], component: FavouritesComponent },
  { path: "home", canActivate: [AuthGuard], component: DashboardComponent },
  { path: "error", component: ErrorComponent },
  { path: "**", component: ErrorComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

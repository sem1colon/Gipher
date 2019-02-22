import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { AccountManagerService } from '../../account-manager.service';


describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [RouterTestingModule, HttpClientModule, ReactiveFormsModule],
      providers: [AccountManagerService]
    })
      .compileComponents();
  }));
  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty', async(() => {
    component.loginForm.controls['userId'].setValue('jgdsfjgfjf@userId.com');
    component.loginForm.controls['password'].setValue('rkekeklgeg');
    expect(component.loginForm.valid).toBeTruthy();
  }));

  it('form should invalid when field is empty', async(() => {
    component.loginForm.controls['userId'].setValue('');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  }));

  it('should call the login method', async(() => {
    component.loginForm.controls['userId'].setValue('sem1colon');
    component.loginForm.controls['password'].setValue('sem1colon');
    spyOn(component, 'login');
    fixture.detectChanges();
    fixture.debugElement.query(By.css('button')).nativeElement.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  }));

  it('form should be invalid when userId is empty', () => {
    component.loginForm.get('password').setValue('password');
    expect(component.loginForm.invalid).toBeTruthy();
  });

  it('form should be invalid when password is empty', () => {
    component.loginForm.get('userId').setValue('sem1colon');
    expect(component.loginForm.invalid).toBeTruthy();
  });

  it('form should be valid', () => {
    component.loginForm.get('userId').setValue('sem1colon');
    component.loginForm.get('password').setValue('hfdhsdlhgklj');
    expect(component.loginForm.valid).toBeTruthy();
  });
});

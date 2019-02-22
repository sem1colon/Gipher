import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule } from '@angular/forms';
import { AccountManagerService } from '../../account-manager.service';
import { SignupComponent } from './signup.component';

describe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SignupComponent],
      imports: [ReactiveFormsModule, HttpClientModule],
      providers: [AccountManagerService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should be invalid when name is empty', () => {
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when name is more than 70chars', () => {
    component.signupForm.get('name').setValue('gsgnkgkfdgfdgdggfdgdgdgdgdgdggdgdgdggdgdgsgaaefrewthhddghdgdggsgxgsgsnfkgjgjkgsdjgakggklgkgkgkfkhgkglkgsghdlweweweweww');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when userId is empty', () => {
    component.signupForm.get('name').setValue('hero');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when password is empty', () => {
    component.signupForm.get('name').setValue('Gokul');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when password is less than 4chars', () => {
    component.signupForm.get('name').setValue('Vishal');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('hal');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when password is more than limit', () => {
    component.signupForm.get('name').setValue('Sangmesh');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('sjgggfdggghhkjdhflgjsgdgsgusfgsdufgudgfufkgisdfgsisdgsdgksgsdgisdsidgsigisdgsidggisgsgsksgigsisigksgishsgjkhgigirgowpoguwgowgowgwoweogwoogpwopw@123admin007admin007admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when confirm password is empty', () => {
    component.signupForm.get('name').setValue('Vamsi');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when confirm password is small', () => {
    component.signupForm.get('name').setValue('kart');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('admin');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when confirm password is blong', () => {
    component.signupForm.get('name').setValue('Vamsi');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('ffffsfafvhfhjfdffjdffgjffjsgffjfhjdjffafgajfgfjgsjkfgsafgkjsdkgggggggggggsdlaggafudgfufgagfilfalf');
    expect(component.signupForm.invalid).toBeTruthy();
  });

  it('form should be invalid when passwords were not match', () => {
    component.signupForm.get('name').setValue('Vamsi');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('karthi@12');
    component.signup();
    expect(component.errorMessage).toEqual("Password didn't matched, Please try again!");
  });

  it('form should be valid', () => {
    component.signupForm.get('name').setValue('Vamsi');
    component.signupForm.get('userId').setValue('admin@userId.com');
    component.signupForm.get('password').setValue('admin007');
    component.signupForm.get('repeatPassword').setValue('admin007');
    expect(component.signupForm.valid).toBeTruthy();
  });
});

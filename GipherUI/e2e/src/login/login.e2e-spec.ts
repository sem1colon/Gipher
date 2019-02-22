import { LoginPage } from './login.po';
import { browser } from 'protractor';

describe('Login Page', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
    page.navigateToLoginPage();
  });



  it('should be able to login as user', () => {
    page.getUserId().sendKeys('sem1colon');
    page.getPassword().sendKeys('admin007');
    page.getLoginButton().click();
    browser.sleep(3000);
    expect(browser.driver.getCurrentUrl()).toContain('home');
  });

  it('should be able disable the login button if password is empty', () => {
    page.getUserId().sendKeys('user@email.com');
    expect(!page.getLoginButton().isEnabled);

  });

  it('should be able to disable the login button if user is empty', () => {
    page.getPassword().sendKeys('password');
    expect(!page.getLoginButton().isEnabled);

  });

  it('should be able to disable the login button if fields are empty', () => {
    expect(!page.getLoginButton().isEnabled);
  });

  it('should be able to get the error message if userid/password is wrong', () => {
    page.getUserId().sendKeys('user@u.');
    page.getPassword().sendKeys('user123');
    page.getLoginButton().click();
    expect(page.getErrorMessage().getText()).toEqual("Invalid Credentials!");
  });

});

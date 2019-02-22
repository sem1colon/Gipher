import { browser, by, element } from 'protractor';

export class LoginPage {
  navigateToLoginPage() {
    return browser.get('/');
  }

  getUserId() {
    return element(by.id('userId'));
  }

  getPassword() {
    return element(by.id('password'));
  }
  getLoginButton() {
    return element(by.id('login'));
  }

  getErrorMessage() {
    return element(by.className('alert'));
  }
}

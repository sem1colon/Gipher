import { browser, by, element } from 'protractor';

export class SignupPage {
    navigateToSignupPage() {
        return browser.get('/signup');
    }
    getName() {
        return element(by.name('name'));
    }

    getUserId() {
        return element(by.name('userId'));
    }

    getPassword() {
        return element(by.name('password'));
    }
    getConfirmPassword() {
        return element(by.id('cPassword'));
    }
    getSignupButton() {
        return element(by.id('signup'));
    }

    getAlertMessage() {
        return element(by.className('alert'));
    }
}

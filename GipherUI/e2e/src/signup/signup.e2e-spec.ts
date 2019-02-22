import { SignupPage } from './signup.po';
import { browser } from 'protractor';

describe('Signup Page', () => {
    let page: SignupPage;

    beforeEach(() => {
        page = new SignupPage();
        page.navigateToSignupPage();
    });

    it('should be able to show error message for already existing email', () => {
        page.getName().sendKeys('admin');
        page.getUserId().sendKeys('sem1colon');
        page.getPassword().sendKeys('admin007');
        page.getConfirmPassword().sendKeys('admin007');
        page.getSignupButton().click();
        browser.sleep(3000);
        expect(page.getAlertMessage().getText()).toEqual("User already exists!");
    });
    it('should be able to disable the signup button if fields are empty', () => {
        expect(!page.getSignupButton().isEnabled);
    });
    it('should be able to disable the signup button if any field is empty', () => {
        page.getPassword().sendKeys('password');
        expect(!page.getSignupButton().isEnabled);
    });
    it('should be able to show error message for password matching', () => {
        page.getName().sendKeys('admin');
        page.getUserId().sendKeys('admin@email.com');
        page.getPassword().sendKeys('admin007');
        page.getConfirmPassword().sendKeys('agdmin007');
        page.getSignupButton().click();
        browser.sleep(1000);
        expect(page.getAlertMessage().getText()).toEqual("Password didn't matched, Please try again!");
    });
});

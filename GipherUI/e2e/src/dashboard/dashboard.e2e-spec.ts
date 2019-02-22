
import { LoginPage } from '../login/login.po';
import { DashboardPage } from './dashboard.po';
import { protractor } from 'protractor/built/ptor';
import { browser } from 'protractor';

describe('Dashboard Page', () => {
    let page = new DashboardPage;
    let loginPage = new LoginPage;

    beforeEach(() => {
        loginPage.navigateToLoginPage();
        loginPage.getUserId().sendKeys('sem1colon');
        loginPage.getPassword().sendKeys('admin007');
        loginPage.getLoginButton().click();
    });
    it('should not be able to click search button when search bar is empty', async () => {
        page.getSearchBar().sendKeys('');
        expect(page.getSearchButton().click()).toBeFalsy();
    });
    it('should be able to get to gifs after search', async () => {
        page.getSearchBar().sendKeys('lol');
        page.getSearchButton().click();
        expect(page.getCardDeck()).toBeTruthy();
    });

    it('should be able to get bookmark button after Search', async () => {
        page.getSearchBar().sendKeys('johncena');
        page.getSearchButton().click();
        expect(page.getBookmarkButton()).toBeTruthy();
    });

    it('should be able to get Favourite Button after Search', async () => {
        page.getSearchBar().sendKeys('johncena');
        page.getSearchButton().click();
        expect(page.getFavoriteButton()).toBeTruthy();
    });

    it('should be able to logout from Dashboard Page', async () => {
        page.getSearchBar().sendKeys('funny');
        page.getSearchButton().click();
        browser.sleep(3000);
        page.getLogoutButton().click();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    });

});

import { browser } from "protractor";
import { DashboardPage } from "../dashboard/dashboard.po";
import { LoginPage } from "../login/login.po";
import { BookmarkPage } from "./bookmarks.po";


describe('Bookmarks page', () => {
    let dashboardpage = new DashboardPage();
    let loginpage = new LoginPage();
    let page = new BookmarkPage();

    beforeEach(() => {
        loginpage.navigateToLoginPage();
        loginpage.getUserId().sendKeys('sem1colon');
        loginpage.getPassword().sendKeys('admin007');
        loginpage.getLoginButton().click();
    });

    it('should be able to navigate to bookmarks page from dashboard', async () => {
        dashboardpage.getLinkToNavigateBookmarks().click();
        expect(browser.driver.getCurrentUrl()).toContain('/bookmarks');
    });

    it('should be able to logout from bookmarks Page', async () => {
        dashboardpage.getLinkToNavigateBookmarks().click();
        page.getLogoutButton().click();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    });

});
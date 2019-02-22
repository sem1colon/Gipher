import { browser } from "protractor";
import { DashboardPage } from "../dashboard/dashboard.po";
import { LoginPage } from "../login/login.po";
import { FavouritePage } from "./favourites.po";


describe('Favourites page', () => {
    let dashboardpage = new DashboardPage();
    let loginpage = new LoginPage();
    let page = new FavouritePage();

    beforeEach(() => {
        loginpage.navigateToLoginPage();
        loginpage.getUserId().sendKeys('sem1colon');
        loginpage.getPassword().sendKeys('admin007');
        loginpage.getLoginButton().click();
    });
 
    it('should be able to navigate to favourite page from dashboard', async () => {
        dashboardpage.getLinkToNavigateFavourites().click();
        expect(browser.driver.getCurrentUrl()).toContain('/favs');
    });

    it('should be able to logout from Favourite Page', async () => {
        dashboardpage.getLinkToNavigateFavourites().click();
        page.getLogoutButton().click();
        expect(browser.driver.getCurrentUrl()).toContain('/login');
    });

});
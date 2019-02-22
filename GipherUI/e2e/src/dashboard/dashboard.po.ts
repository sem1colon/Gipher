import { browser, by, element } from 'protractor';

export class DashboardPage {

    getSearchBar() {
        return element(by.id('q'));
    }

    getSearchButton() {
        return element(by.id('search-btn'));
    }

    getAlertMessage() {
        return element(by.className('alert'));
    }
    getBookmarkButton() {
        return element(by.className("far fa-bookmark"));
    }

    getFavoriteButton() {
        return element(by.className("far fa-heart"));
    }
    getLogoutButton() {
        return element(by.id("logout"));
    }

    getLinkToNavigateBookmarks() {
        return element(by.id("bookmarks"));
    }
    getLinkToNavigateFavourites() {
        return element(by.id("favourites"));
    }
    getCardDeck() {
        return element(by.className("card-deck"));
    }
}

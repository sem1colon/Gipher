import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class BookmarkPage {

    getTitle() {
        return element(by.className("title"));
    }

    getCardDeck() {
        return element(by.className("card-deck"));
    }

    getLogoutButton() {
        return element(by.id("logout"));
    }

}

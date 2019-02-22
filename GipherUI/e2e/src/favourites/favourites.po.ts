import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class FavouritePage {

    getTitle() {
        return element(by.css('h1'));
    }

    getCardDeck() {
        return element(by.className("card-deck"));
    }

    getLogoutButton() {
        return element(by.id("logout"));
    }

}

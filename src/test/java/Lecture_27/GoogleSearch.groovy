package Lecture_27

import geb.Browser
import org.openqa.selenium.Keys
import spock.lang.Specification

class GoogleSearch extends Specification {

    def "Test Search "() {
        def browser = new Browser()
        given:
        browser.to GoogleSearchPage

        when:
        browser.page(GoogleSearchPage).searchField << "Hello world!"

        then:
        browser.page(GoogleSearchPage).searchField << Keys.ENTER

        then:
        browser.page(SearchResultPage).checkSearchResult
    }
}

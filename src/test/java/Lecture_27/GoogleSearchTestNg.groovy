package Lecture_27


import geb.Browser
import geb.spock.GebSpec
import org.openqa.selenium.Keys
import org.testng.annotations.Test

class GoogleSearchTestNg extends GebSpec {

    @Test
    void testSearch() {
        def browser = new Browser()
        browser.to GoogleSearchPage
        browser.page(GoogleSearchPage).searchField << "Hello world!"
        browser.page(GoogleSearchPage).searchField << Keys.ENTER
        assert browser.page(SearchResultPage).resultStats.text().contains("1")
    }
}

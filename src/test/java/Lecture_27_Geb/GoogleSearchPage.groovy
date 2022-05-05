package Lecture_27_Geb

import geb.Page

class GoogleSearchPage extends Page {
    static content = {
        searchField { $('[name="q"]') }
    }
}

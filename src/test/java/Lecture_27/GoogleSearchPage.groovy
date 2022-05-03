package Lecture_27

import geb.Page

class GoogleSearchPage extends Page {
    static content = {
        searchField { $('[name="q"]') }
    }
}

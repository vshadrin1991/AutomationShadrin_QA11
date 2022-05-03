package Lecture_27

import geb.Page

class SearchResultPage extends Page {
    static content = {
        checkSearchResult { $('#result-stats').text().contains("Результатов: примерно") }
    }
}

package Lecture_27_Geb

import geb.Page

class SearchResultPage extends Page {
    static content = {
        resultStats { $('#result-stats') }
    }

}

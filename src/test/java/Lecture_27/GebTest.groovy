package Lecture_27

import geb.Browser
import org.openqa.selenium.Keys

Browser.drive {
    go "/"

    $('[name="q"]').value("Hello world") << Keys.ENTER

    assert $('#result-stats').text().contains("Результатов: примерно")
}

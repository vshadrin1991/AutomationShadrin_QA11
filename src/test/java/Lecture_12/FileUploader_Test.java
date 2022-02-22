package Lecture_12;

import BaseObjects.BaseTest;
import PageObject.herokuapp.FileUploaderPage;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomeLinks.FILE_UPLOADER;

public class FileUploader_Test extends BaseTest {

    @Test
    public void fileUploader_Test() {
        get(HomePage.class).clickLink(FILE_UPLOADER);
        get(FileUploaderPage.class)
                .verifyPageTitle("File Uploader")
                .uploadFile()
                .clickFileSubmit()
                .verifyPageTitle("File Uploaded!")
                .verifyThatFileUploaded("image.jpeg");
    }
}

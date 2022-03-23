package PageObject.RabotaBy;

public interface ElementInterface<T> {
    T checkElement();

    default void verifyElementIsLoaded() {
    }
}

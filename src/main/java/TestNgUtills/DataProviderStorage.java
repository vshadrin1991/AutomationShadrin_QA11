package TestNgUtills;

import org.testng.annotations.DataProvider;

public class DataProviderStorage {

    @DataProvider(name = "Входящие данные для задачи TeachMeSkills")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {3, "Teach"},
                {5, "Me"},
                {15, "Skills"},
                {6, "TeachMe"},
                {10, "TeachMeSkills"},
                {30, "Teach Me Skills"},
                {1, "Все нет то, переделывай"},
                {-1, "Все не так, переделывай"},
                {1000000000, "Абсалютли"},
                {3.3, "Вот так вот"}
        };
    }
}

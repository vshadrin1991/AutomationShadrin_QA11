package Lecture_16;

import Entity.Car;
import Entity.Student;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lecture_16 {

    @Test(priority = 1, dataProvider = "student")
    public void student_Test(Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student);
    }

    @Test(priority = 2)
    public void car_Test() {
        Car car = new Car.CarIndustry().withBrand("Audi").withColor("Black").withV(2.0).create();
        System.out.println(car);
    }

    @DataProvider(name = "student")
    private Object[][] getStudent() {
        return new Object[][]{
                {new Student("Test", "Test", 21, "Math", "Test-51")},
                {new Student() {{
                    setFirstName("User");
                    setAge(18);
                }}}
        };
    }
}

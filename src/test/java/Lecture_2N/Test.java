package Lecture_2N;

public class Test {

    public static void reader(){
        Student student = new Student();
        student.read(new Book());
        student.read(new News());
        student.read(new Mem());
    }


    public static void main(String[] args) {
        reader();
    }
}

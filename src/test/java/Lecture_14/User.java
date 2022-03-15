package Lecture_14;

public class User {
    String firstName;
    String lastName;
    Integer age;
    String sex;
    Integer phone;
    String job = "QA";

    public static class Builder {
        private User user;

        public Builder() {
            this.user = new User();
        }

        public Builder withFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        public Builder withAge(Integer age) {
            user.age = age;
            return this;
        }

        public Builder withSex(String sex) {
            user.sex = sex;
            return this;
        }

        public Builder withPhone(Integer phone) {
            user.phone = phone;
            return this;
        }

        public Builder withJob(String job) {
            user.job = job;
            return this;
        }

        public User build() {
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", job='" + job + '\'' +
                '}';
    }
}

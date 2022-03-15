package Lecture_14;

public class OnlinerUser {
    String email;
    String password;
    String repeatPassword;

    public static class Builder {
        private OnlinerUser user;

        public Builder() {
            this.user = new OnlinerUser();
        }

        public Builder withEmail(String email) {
            user.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            user.password = password;
            return this;
        }

        public Builder withRepeatPassword(String repeatPassword) {
            user.repeatPassword = repeatPassword;
            return this;
        }

        public OnlinerUser build() {
            return user;
        }
    }
}

package Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class User {
    private String userName;
    private String password;

    public static class UserBuilder {
        public UserBuilder() {
        }
    }
}

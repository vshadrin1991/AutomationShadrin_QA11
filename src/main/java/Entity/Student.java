package Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String secondName;
    private Integer age;
    private String faculty;
    private String group;
}

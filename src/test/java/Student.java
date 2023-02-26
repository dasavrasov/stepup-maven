import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Integer id;
    private String name;
    private List marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public List getMarks() {
        return new ArrayList<>(marks);
    }

}
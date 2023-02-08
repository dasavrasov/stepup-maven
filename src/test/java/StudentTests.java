import org.junit.jupiter.api.*;
import ru.stepup.payments.mobile.Student;

import java.util.List;

public class StudentTests {

    @RepeatedTest(value = 4, name = "добавление корректной оценки")
    void testCorrectGrades(RepetitionInfo repetitionInfo) {
        Student stud = new Student("vasia");
        stud.addGrade(repetitionInfo.getCurrentRepetition() + 1);
        Assertions.assertEquals(stud.getGrades().get(0), repetitionInfo.getCurrentRepetition() + 1);
    }

    @Test
    @DisplayName("добавление неверных оценок кидает исключение")
    public void marksNotInRange() {
        List<Integer> lst = List.of(12, 13, 14, 15);
        Student stud = new Student("vasia");
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(0)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(2)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(3)));
    }

    @Test
    @DisplayName("тест инкапсуляции. Проверяет что через getGrades.add нельзя добавить некорректную оценку")
    void testGetGrades() {
        Student stud = new Student("vasia");
        Assertions.assertThrows(java.lang.UnsupportedOperationException.class, () -> stud.getGrades().add(4));
    }

    @Test
    @DisplayName("тест получения имени студента")
    public void testGetName() {
        Student stud = new Student("vasia");
        Assertions.assertEquals(stud.getName(), "vasia");
    }

    @Test
    @DisplayName("тест изменения имени")
    public void testSetName() {
        Student stud = new Student("vasia");
        stud.setName("Pete");
        Assertions.assertEquals(stud.getName(), "Pete");
    }

    @Test
    @DisplayName("тест Equals")
    public void testEquals() {
        Student stud1 = new Student("vasia");
        Student stud2 = new Student("pete");
        Student stud3 = new Student("pete");
        Assertions.assertNotEquals(stud1, stud2);
        Assertions.assertEquals(stud2, stud3);
    }

    @Test
    @DisplayName("тест HashCode")
    public void testHashCode() {
        Student stud1 = new Student("vasia");
        stud1.addGrade(4);
        Student stud2 = new Student("pete");
        stud2.addGrade(2);
        Student stud3 = new Student("pete");
        stud3.addGrade(2);
        Student stud4 = new Student("vasia");
        stud4.addGrade(4);
        stud4.addGrade(5);
        Assertions.assertNotEquals(stud1.hashCode(), stud2.hashCode());
        Assertions.assertEquals(stud2.hashCode(), stud3.hashCode());
        Assertions.assertNotEquals(stud1.hashCode(), stud4.hashCode());
    }

    @Test
    @DisplayName("тест toString")
    public void testToString() {
        Student stud1 = new Student("vasia");
        stud1.addGrade(4);
        Student stud2 = new Student("vasia");
        stud2.addGrade(2);
        stud2.addGrade(3);
        Assertions.assertNotEquals(stud1.toString(), stud2.toString());
        Student stud3=new Student("vasia");
        stud3.addGrade(4);
        Assertions.assertEquals(stud1.toString(), stud3.toString());
    }
}

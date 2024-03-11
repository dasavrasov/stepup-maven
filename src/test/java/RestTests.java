import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RestTests {
    @Test
    public void testName(){
        get("http://localhost:8080/getStudent").then().body("name", notNullValue());
    }
    @Test
    public void testGradesNotNull(){
        get("http://localhost:8080/getStudent").then().body("grades", notNullValue());
    }
    @Test
    public void testGradesValuesIn2_and_5(){
        List<Integer> grades= get("http://localhost:8080/getStudent").then().extract().path("grades");
        Assertions.assertTrue(grades.stream().anyMatch(x-> x>=2 && x<=5) || grades.isEmpty());
        grades= get("http://localhost:8080/wrongStudent").then().extract().path("grades");
        Assertions.assertTrue(!grades.isEmpty() && grades.stream().noneMatch(x-> x>=2 && x<=5) );
    };

}

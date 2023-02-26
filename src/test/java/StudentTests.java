import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.stepup.payments.mobile.Student;

import java.util.ArrayList;
import java.util.List;
public class StudentTests {
    /*
    * get /student/{id} возвращает JSON студента с указанным ID и заполненным именем, если такой есть в базе, код 200.
     */
    @Test
    public void test1(){
        RestAssured.given()
                .baseUri("http://localhost:8080/student/1")
                .when().get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("id",Matchers.equalTo("id"))
                .body("name", Matchers.notNullValue());
    }

    /*
    * 2. get /student/{id} возвращает код 404, если студента с данным ID в базе нет.
     */
    @Test
    public void test2(){
        RestAssured.given()
                .baseUri("http://localhost:8080/student/-1")
                .when().get()
                .then()
                .statusCode(404);
    }

    /*
    * 3. post /student добавляет студента в базу, если студента с таким ID ранее не было,
    * при этом имя заполнено, код 201.
     */
    @Test @SneakyThrows
    public void test3(){
        Student student=new Student();
        student.setName("pete");
        ObjectMapper mapper=new ObjectMapper();
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201)
                .body("name",Matchers.equalTo(student.getName()));
    }
    /*
    * 4. post /student обновляет студента в базе, если студент с таким ID ранее был, при этом имя заполнено, код 201.
     */
    @Test @SneakyThrows
    public void test4(){
        Student student=new Student();
        student.setName("pete");
        ObjectMapper mapper=new ObjectMapper();
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201)
                .body("name",Matchers.equalTo(student.getName()));
    }


}

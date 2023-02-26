import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
                .body("id",Matchers.equalTo(1))
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
        student.setId(2);
        student.setName("Denis");
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student));
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .body(mapper.writeValueAsString(student))
                .contentType(ContentType.JSON)
                .when().post()
                .then()
                .statusCode(201);
    }
    /*
    * 4. post /student обновляет студента в базе, если студент с таким ID ранее был, при этом имя заполнено, код 201.
     */
    @Test @SneakyThrows
    public void test4(){
        Student student=new Student();
        student.setId(1);
        student.setName("pete1");
        ObjectMapper mapper=new ObjectMapper();
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201);
    }

    /*
    *  5. post /student добавляет студента в базу, если ID null, то возвращается назначенный ID, код 201.
     */
    @Test @SneakyThrows
    public void test5(){
        Student student=new Student();
        student.setName("PeteWithNullId");
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student));
        Integer res=RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201)
                .extract().as(Integer.class);

        System.out.println(res);
        Assertions.assertNotNull(res);
    }

    /*
    * 6. post /student возвращает код 400, если имя не заполнено.
     */
    @Test @SneakyThrows
    public void test6(){
        Student student=new Student();
        student.setId(1);
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student));
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(400);
    }
/*
    7. delete /student/{id} удаляет студента с указанным ID из базы, код 200.
 */
@Test @SneakyThrows
public void test7(){
    RestAssured.given()
            .baseUri("http://localhost:8080/student/1")
            .when().delete()
            .then()
            .statusCode(200);
}
/*
    8.delete /student/{id} возвращает код 404, если студента с таким ID в базе нет.
 */
@Test @SneakyThrows
public void test8(){
    RestAssured.given()
            .baseUri("http://localhost:8080/student/-1")
            .when().delete()
            .then()
            .statusCode(404);
}

/*
 * 9. get /topStudent код 200 и пустое тело, если студентов в базе нет.
 */
@Test @SneakyThrows
public void test9(){

    Response response=RestAssured.given()
            .baseUri("http://localhost:8080/topStudent/")
            .when().get()
            .then()
            .statusCode(200)
            .extract().response().andReturn();
    Assertions.assertTrue(response.getBody().asString().isEmpty());
}


}

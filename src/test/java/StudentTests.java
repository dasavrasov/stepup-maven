import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentTests {
    /*
    * get /student/{id} возвращает JSON студента с указанным ID и заполненным именем, если такой есть в базе, код 200.
     */
    @SneakyThrows
    public static void createStudent(int id, String name, List<Integer> marks){
        //добавить в БД студента с ID=1
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setMarks(marks);
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student));
        RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .body(mapper.writeValueAsString(student))
                .contentType(ContentType.JSON)
                .when().post();
    }
    @SneakyThrows
    public static void deleteStudent(int id){
        //удалить в БД студента с ID=1
        RestAssured.given()
                .baseUri("http://localhost:8080/student/"+id)
                .contentType(ContentType.JSON)
                .when().delete();
    }

    public static boolean isStudentExists(int id){
        Student student= null;
        try {
            student = RestAssured.given()
                    .baseUri("http://localhost:8080/student/"+id)
                    .when().get()
                    .then()
                    .extract().as(Student.class);
        } catch (Exception e) {
            return false;
        }
        if (student==null)
            return false;
        return true; //нашли студента
    }

    public static Student getStudent(int id){
        Student student= null;
        try {
            student = RestAssured.given()
                    .baseUri("http://localhost:8080/student/"+id)
                    .when().get()
                    .then()
                    .extract().as(Student.class);
        } catch (Exception e) {
            return null;
        }
        return student;
    }

    @Test @SneakyThrows
    @DisplayName("1. get /student/{id} возвращает JSON студента с указанным ID и заполненным именем, если такой есть в базе, код 200")
    public void test1(){
        createStudent(1,"Denis",new ArrayList<>());
        RestAssured.given().log().all()
                .baseUri("http://localhost:8080/student/1")
                .when().get()
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("id",Matchers.equalTo(1))
                .body("name", Matchers.notNullValue());
        deleteStudent(1);
    }

    /*
    * 2. get /student/{id} возвращает код 404, если студента с данным ID в базе нет.
     */
    @Test
    @DisplayName("2. get /student/{id} возвращает код 404, если студента с данным ID в базе нет.")
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
    @DisplayName("3. post /student добавляет студента в базу, если студента с таким ID ранее не было, при этом имя заполнено, код 201.")
    public void test3(){
        Student student=new Student();
        int id= new Random().nextInt();
        student.setId(id);
        student.setName("Denis");
        while (isStudentExists(id)==false) {  //студента с таким id нет в БД, создаем
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(student));
            RestAssured.given()
                    .baseUri("http://localhost:8080/student")
                    .body(mapper.writeValueAsString(student))
                    .contentType(ContentType.JSON)
                    .when().post()
                    .then()
                    .statusCode(201);
        }
        if (isStudentExists(id))
            deleteStudent(id); //удаляем студента с таким id
    }
    /*
    * 4. post /student обновляет студента в базе, если студент с таким ID ранее был, при этом имя заполнено, код 201.
     */
    @Test @SneakyThrows
    @DisplayName("4. post /student обновляет студента в базе, если студент с таким ID ранее был, при этом имя заполнено, код 201.")
    public void test4(){
        createStudent(1,"Denis",new ArrayList<>());
        Student student=new Student();
        student.setId(1);
        student.setName("pete1"); //меняем имя студента на pete1
        ObjectMapper mapper=new ObjectMapper();
        RestAssured.given().log().all()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201);
        Student student1=getStudent(1);
        Assertions.assertEquals(student1.getName(),"pete1");
    }

    /*
    *  5. post /student добавляет студента в базу, если ID null, то возвращается назначенный ID, код 201.
     */
    @Test @SneakyThrows
    @DisplayName("5. post /student добавляет студента в базу, если ID null, то возвращается назначенный ID, код 201.")
    public void test5(){
        Student student=new Student();
        student.setName("PeteWithNullId");
        ObjectMapper mapper=new ObjectMapper();
        Integer studentId=RestAssured.given()
                .baseUri("http://localhost:8080/student")
                .contentType(ContentType.JSON)
                .body(mapper.writeValueAsString(student))
                .when().post()
                .then()
                .statusCode(201)
                .extract().as(Integer.class);

        System.out.println(studentId);
        Assertions.assertNotNull(studentId);
    }

    /*
    * 6. post /student возвращает код 400, если имя не заполнено.
     */
    @Test @SneakyThrows
    @DisplayName("6. post /student возвращает код 400, если имя не заполнено.")
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
    @DisplayName("7. delete /student/{id} удаляет студента с указанным ID из базы, код 200.")
    public void test7(){
        //создаем студента
        createStudent(1,"Denis", new ArrayList<>());
        //удаляем
        RestAssured.given()
                .baseUri("http://localhost:8080/student/1")
                .when().delete()
                .then()
                .statusCode(200);
        //проверяем, что после удаления его нет
        Assertions.assertFalse(isStudentExists(1));
        deleteStudent(1);
    }
    /*
        8.delete /student/{id} возвращает код 404, если студента с таким ID в базе нет.
     */
    @Test @SneakyThrows
    @DisplayName("8. delete /student/{id} возвращает код 404, если студента с таким ID в базе нет.")
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
    @DisplayName("9. get /topStudent код 200 и пустое тело, если студентов в базе нет.")
    public void test9(){

        Response response=RestAssured.given()
                .baseUri("http://localhost:8080/topStudent/")
                .when().get()
                .then()
                .statusCode(200)
                .extract().response().andReturn();
        Assertions.assertTrue(response.getBody().asString().isEmpty());
    }

    /*
     *  10. get /topStudent код 200 и пустое тело, если ни у кого из студентов в базе нет оценок.
     */
    @Test @SneakyThrows
    @DisplayName("10. get /topStudent код 200 и пустое тело, если ни у кого из студентов в базе нет оценок.")
    public void test10(){
        createStudent(1,"Denis", new ArrayList<>());
        Response response=RestAssured.given()
                .baseUri("http://localhost:8080/topStudent/")
                .when().get()
                .then()
                .statusCode(200)
                .extract().response().andReturn();
        Assertions.assertTrue(response.getBody().asString().isEmpty());
        deleteStudent(1);
    }

    /*
     * 11. get /topStudent код 200 и один студент, если у него максимальная средняя оценка, либо же среди всех студентов с максимальной средней у него их больше всего.
     */
    @Test
    @DisplayName("11. get /topStudent код 200 и один студент, если у него максимальная средняя оценка, либо же среди всех студентов с максимальной средней у него их больше всего.")
    public void test11(){
        createStudent(1,"Denis", Arrays.asList(2,2,2));
        createStudent(2,"Vovan", Arrays.asList(5,5,5));
        createStudent(3,"Tanya", Arrays.asList(5,5,5,5,5));
        String topStudentName=RestAssured.given().log().all()
                .baseUri("http://localhost:8080/topStudent/")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("name");

        Assertions.assertTrue(topStudentName.contains("Tanya"));
        deleteStudent(1);
        deleteStudent(2);
    }

    /*
     * 12. get /topStudent код 200 и несколько студентов, если у них всех эта оценка максимальная и при этом они равны по количеству оценок.
     */
    @Test
    @DisplayName("12. get /topStudent код 200 и несколько студентов, если у них всех эта оценка максимальная и при этом они равны по количеству оценок.")
    public void test12(){
        createStudent(1,"Denis", Arrays.asList(5,5,5));
        createStudent(2,"Vovan", Arrays.asList(5,5,5));
        createStudent(3,"Tanya", Arrays.asList(2,2,2));
        List<String> students=RestAssured.given().log().all()
                .baseUri("http://localhost:8080/topStudent/")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getList("name");

        Assertions.assertTrue(students.contains("Denis"));
        Assertions.assertTrue(students.contains("Vovan"));
        Assertions.assertFalse(students.contains("Tanya"));
        deleteStudent(1);
        deleteStudent(2);
        deleteStudent(3);
    }

}

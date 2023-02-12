import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import ru.stepup.payments.mobile.Student;

import java.util.ArrayList;
import java.util.List;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class StudentTests {

    private ClientAndServer mockServer;

    @BeforeEach
    public void startServer() {
        mockServer = startClientAndServer(5352);
    }

    @AfterEach
    public void stopServer() {
        mockServer.stop();
    }

    @ParameterizedTest(name="Неправильные не попадают в список оценок")
    @ValueSource(ints = {12,14})
    void testIncorrectGrade(int grade) {
        Student stud=new Student("vasia");
        MockServerClient mockClient = new MockServerClient("localhost", 5352);
        mockClient.when(request().withMethod("GET")
                .withPath("/checkGrade")
                .withQueryStringParameter("grade",String.valueOf(grade)))
                .respond(response().withBody("false").withStatusCode(200));

        Assertions.assertThrows(IllegalArgumentException.class,()->stud.addGrade(grade));
    }

    @ParameterizedTest(name="Правильные попадают в список оценок")
    @ValueSource(ints = {4,2,5})
    void testCorrectGrade(int grade) {
        List<Integer> expectedList=new ArrayList<>();
        expectedList.add(grade);
        Student stud=new Student("vasia");
        MockServerClient mockClient = new MockServerClient("localhost", 5352);
        mockClient.when(request().withMethod("GET")
                .withPath("/checkGrade")
                .withQueryStringParameter("grade",String.valueOf(grade)))
                .respond(response().withBody("true").withStatusCode(200));
        stud.addGrade(grade);
        Assertions.assertEquals(stud.getGrades().get(0),expectedList.get(0));
    }

}

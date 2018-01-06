package PUT;

import Student_Model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PUT_Test {

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void updateStudentInfo(){

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("JAVA");

        Student student = new Student();
        student.setFirstName("Abzal2222");
        student.setLastName("Issabekov");
        student.setEmail("TesT@gmail.ru");
        student.setProgramme("QAAAAAAAAAAAAAA");
        student.setCourses(courses);

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("/102")
                .then()
                .statusCode(200);

    }
}

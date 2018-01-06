package Student.Logging;

import Student_Model.Base;

import static io.restassured.RestAssured.*;

import Student_Model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Logging extends Base {

    // this  test will print out all the request headers

    @Test
    public void test001() {

        System.out.println("------------Printing Request Header-------------\n");

        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);

    }

    @Test
    public void test002() {

        System.out.println("------------Printing Request Parameters-------------");

        given()
                .param("proramme", "Computer Science")
                .param("limit", 1)
                .log()
                .params()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }

    // printing request body

    @Test
    public void test003() {

        System.out.println("------------Printing Request Body-------------");


        ArrayList<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("JAVA");

        Student student = new Student();
        student.setFirstName("Abzal");
        student.setLastName("Issabekov");
        student.setEmail("TesT@gmail.ru");
        student.setProgramme("QA");
        student.setCourses(courses);

        RestAssured
                .given()
                .log()
                .body()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post();
    }

    // print all details

    @Test
    public void test004() {

        System.out.println("------------Printing All Request Details------------");


        ArrayList<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("JAVA");

        Student student = new Student();
        student.setFirstName("Abzal");
        student.setLastName("Issabekov");
        student.setEmail("TesT@gmail.ru");
        student.setProgramme("QA");
        student.setCourses(courses);

        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post();
    }

    // print out if validation fails

    @Test
    public void test005() {

        System.out.println("------------Printing All Request Details if Validation Fails------------");


        ArrayList<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("JAVA");

        Student student = new Student();
        student.setFirstName("Abzal346364758");
        student.setLastName("Issabekov34tt4t");
        student.setEmail("TesT2344@gmail.ru");
        student.setProgramme("QA");
        student.setCourses(courses);

        RestAssured
                .given()
                .log()
                .ifValidationFails()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);
    }
}

package Student.Logging;

import Student_Model.Base;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Logging_Information extends Base{

    @Test
    public void test001() {

        System.out.println("------------Printing Response Headers-------------");

        given()
                .param("proramme", "Computer Science")
                .param("limit", 1)
                .when()
                .get("/list")
                .then()
                .log()
                .headers()
                .statusCode(200);
    }

    @Test
    public void test002() {

        System.out.println("------------Printing Response Body-------------");

        given()
                .param("proramme", "Computer Science")
                .param("limit", 1)
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .statusCode(200);
    }
}

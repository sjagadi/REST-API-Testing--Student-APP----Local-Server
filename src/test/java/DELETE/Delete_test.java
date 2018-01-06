package DELETE;

import Student_Model.Base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Delete_test extends Base{

//    @BeforeClass
//    public static void init() {
//
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8080;
//        RestAssured.basePath = "/student";
//    }

    @Test
    public void deleteStudentFromList(){

        RestAssured
                .given()
                .when()
                .delete("/102")
                .then()
                .statusCode(204);

    }
}

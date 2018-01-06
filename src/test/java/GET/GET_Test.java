package GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GET_Test {

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void getAllStudentInformation() {
        /*
        * given()
        * set cookies, add auth, adding parameters, setting header info
        * .when()
        * GET, POST,PUT,Delete
        * .then()
        * Validate status code, extract response, extract headers, cookies,extract response body
        *
        * */
        Response response = RestAssured
                .given()
                .when()
                .get("list");

        System.out.println(response.body().prettyPeek());

        //Validate the status code

        RestAssured
                .given()
                .when()
                .get("list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentInfo() {
        Response response = RestAssured
                .given()
                .when()
                .get("/1");

        System.out.println(response.body().prettyPeek());

        RestAssured
                .given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentFromFA(){
        Response response = RestAssured
                .given()
                .when()
                .get("/list?programme=Computer Science&limit=2");

        //System.out.println(response.body().prettyPeek());


        // another way to use parameters!
        Response response1 = RestAssured
                .given()
                .param("programme","Computer Science")
                .param("limit",3)
                .when()
                .get("/list");

        System.out.println(response1.body().prettyPeek());

    }
}

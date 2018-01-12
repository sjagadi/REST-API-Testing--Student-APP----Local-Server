package ExtractREquestResponse;

import Student_Model.Base;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.PrintStream;
import java.io.StringWriter;

public class FilterRequestAndResponse {

    public static StringWriter requestWriter;
    public static PrintStream requestCapture;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/student";
    }

    @Before
    public void beforeEachTest() {
        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
    }

    @Test

    public void getStudetn() {
        String response = RestAssured.given()
                .when()
                .get("/list")
                .asString();

        //System.out.println(response);

        RestAssured.given()
                .filter(new RequestLoggingFilter(requestCapture))
                .when()
                .get("/list");

        System.err.println(requestWriter.toString());
    }


}

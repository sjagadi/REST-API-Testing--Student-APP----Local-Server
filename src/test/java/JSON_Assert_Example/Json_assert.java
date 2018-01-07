package JSON_Assert_Example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Json_assert {

    @Test
    public void getStudents() throws IOException {
        String expectedValue = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +
                File.separator + "file.txt")));

        String actualValue = RestAssured.given().when().get("http://localhost:8080/student/list").asString();

        System.out.println(expectedValue);
        System.out.println(actualValue);
    }
}

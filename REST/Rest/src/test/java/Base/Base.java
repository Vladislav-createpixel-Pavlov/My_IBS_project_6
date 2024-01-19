package Base;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Base {
    public static void Insert(){
       given()
                .baseUri("http://localhost:8080/")
                .header("Content-Type","application/json")
               .header("accept"," */*")
                .and()
                .body("{\"name\": \"Картофель\", \"type\": \"VEGETABLE\", \"exotic\": false}")
                .when()
                .post("api/food")
                .then()
               .assertThat()
               .statusCode(200);
        Response response = given()
                .baseUri("http://localhost:8080/")
                .header("accept"," */*")
                .when()
                .log().all()
                .get("api/food");
        Assertions.assertEquals("[Апельсин, Капуста, Помидор, Яблоко, Картофель]",response.jsonPath().getString("name"));

    }
    public static void Check(){
        Response response = given()
                .baseUri("http://localhost:8080/")
                .when()
                .log().all()
                .get("api/food");
        Assertions.assertEquals("[Апельсин, Капуста, Помидор, Яблоко, Картофель]",response.jsonPath().getString("name"));
    }
}
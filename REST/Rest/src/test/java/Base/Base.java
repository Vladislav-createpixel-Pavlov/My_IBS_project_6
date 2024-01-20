package Base;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;

public class Base {
    public static void Insert(){
       Response response = given()
                .baseUri("http://localhost:8080/")
                .header("Content-Type","application/json")
               .header("accept"," */*")
                .and()
                .body("{\"name\": \"Картофель\", \"type\": \"VEGETABLE\", \"exotic\": false}")
                .when()
               .log().all()
                .post("api/food")
               .then()
               .log().all()
               .extract().response();
       String cook = response.cookie("JSESSIONID") ;

//               .assertThat()
//               .statusCode(200);


        Response response1 = given()
                .header("accept"," */*")
                .cookie("JSESSIONID",cook)
                //куки
                //сессия параметр
                .when()
                .log().all()
                .get("api/food");
        Assertions.assertEquals("[Апельсин, Капуста, Помидор, Яблоко, Картофель]",response1.jsonPath().getString("name"));

    }

}
package tests;

import Base.Base;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.opentelemetry.api.internal.ApiUsageLogger.log;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class RestTest extends Base {

    @Test
    void test1() {
        Base.Insert();

   }


}

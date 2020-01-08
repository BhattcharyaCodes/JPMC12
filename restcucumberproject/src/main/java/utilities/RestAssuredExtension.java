package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension() {
            //Arrange
            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBaseUri("https://jsonplaceholder.typicode.com");
            builder.setContentType(ContentType.JSON);
            RequestSpecification requestSpec = builder.build();
            Request = RestAssured.given().spec(requestSpec);
        }

        public static void GetOpsWithPathParameters(String url, Map<String, String> pathParams) throws URISyntaxException {
            Request.pathParams(pathParams);
            Request.get(new URI(url));
        }

        public static ResponseOptions<Response> GetOps(String url) {
            try {
                return Request.get(new URI(url));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static ResponseOptions<Response> PostOps(String url, String body) throws URISyntaxException {
            Request.body(body);
            return Request.post(new URI(url));
        }


    }

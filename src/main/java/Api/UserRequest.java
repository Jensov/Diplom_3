package Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import User.*;

import static io.restassured.RestAssured.given;

public class UserRequest {
    public final static String ROOT = "https://stellarburgers.nomoreparties.site/api/auth/";

    public static Response deleteUser(String token) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .when()
                .delete(ROOT + "user");
    }

    public static String getToken(RegistrationUser user) {
        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", user.getEmail(), user.getPassword()))
                .post(ROOT + "login");

        response.then().statusCode(200);

        return response.jsonPath().getString("accessToken");
    }
}

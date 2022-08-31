package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String USER_PATH = "/api/auth/register";
    private static final String USER_LOGIN_PATH = "/api/auth/login";
    private static final String USER_DELETE_PATH = "/api/auth/user";
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Создать пользователя")
    public static String create(User user) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(USER_PATH)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken").toString();
    }

    @Step("Авторизовать пользователя")
    public static String loginUser(Credentials credentials) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post(USER_LOGIN_PATH)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken").toString();
    }

    @Step("Удалить пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .log().all()
                .baseUri(BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", accessToken)
                .when()
                .delete(USER_DELETE_PATH)
                .then()
                .assertThat()
                .statusCode(202)
                .extract()
                .path("ok");
    }
}

package tests;

import com.github.javafaker.Faker;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static service.UserService.createUser;
import static support.utils.GetProperties.getProp;
import static support.utils.RestContext.*;
import static org.junit.Assert.*;

public class RegisterUserTest {

    ValidatableResponse jsonResponse;
    static Faker faker = new Faker();
    static String fakeName = faker.name().firstName();
    static String fakeEmail = faker.name().firstName() + "@gmail.com";

    @Test
    public void postRegisterUserSuccessful(){
        createUser(fakeName, fakeEmail, "123456", false);
        jsonResponse = getResponse().then().log().all();
        String message = jsonResponse.extract().path("message");

        assertEquals(getProp("create-user-successful"), message);
        assertNotNull("_id");
    }

    @Test
    public void postRegisterUserWithoutName(){
        createUser("", fakeEmail, "123456", false);
        jsonResponse = getResponse().then().log().all();
        String message = jsonResponse.extract().path("nome");

        assertEquals(getProp("without-name"), message);
    }

    @Test
    public void postRegisterUserWithoutEmail(){
        createUser(fakeName, "", "123456", false);
        jsonResponse = getResponse().then().log().all();
        String message = jsonResponse.extract().path("email");

        assertEquals(getProp("without-email"), message);
    }

    @Test
    public void postRegisterUserWithoutPassword(){
        createUser(fakeName, fakeEmail, "", false);
        jsonResponse = getResponse().then().log().all();
        String message = jsonResponse.extract().path("password");

        assertEquals(getProp("without-password"), message);
    }

    @Test
    public void postRegisterUserInvalidEmail(){
        createUser(fakeName, "@gmail.com", "123456", false);
        jsonResponse = getResponse().then().log().all();
        String message = jsonResponse.extract().path("email");

        assertEquals(getProp("invalid-email"), message);
    }

}

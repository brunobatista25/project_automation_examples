package tests

import com.github.javafaker.Faker
import io.restassured.response.ValidatableResponse
import org.junit.Assert
import org.junit.Test
import service.UserService.createUser
import support.utils.GetProperties.getProp
import support.utils.RestContext.response

class RegisterUserTest {
    lateinit var jsonResponse: ValidatableResponse
    var faker = Faker()
    var fakeName: String = faker.name().firstName()
    var fakeEmail: String = faker.name().firstName() + "@gmail.com"

    @Test
    fun postRegisterUserSuccessful() {
        createUser(fakeName, fakeEmail, "123456", false)
        jsonResponse = response!!.then().log().all()
        val message = jsonResponse.extract().path<String>("message")
        Assert.assertEquals(getProp("create-user-successful"), message)
        Assert.assertNotNull("_id")
    }

    @Test
    fun postRegisterUserWithoutName() {
        createUser("", fakeEmail, "123456", false)
        jsonResponse = response!!.then().log().all()
        val message = jsonResponse.extract().path<String>("nome")
        Assert.assertEquals(getProp("without-name"), message)
    }

    @Test
    fun postRegisterUserWithoutEmail() {
        createUser(fakeName, "", "123456", false)
        jsonResponse = response!!.then().log().all()
        val message = jsonResponse.extract().path<String>("email")
        Assert.assertEquals(getProp("without-email"), message)
    }

    @Test
    fun postRegisterUserWithoutPassword() {
        createUser(fakeName, fakeEmail, "", false)
        jsonResponse = response!!.then().log().all()
        val message = jsonResponse.extract().path<String>("password")
        Assert.assertEquals(getProp("without-password"), message)
    }

    @Test
    fun postRegisterUserInvalidEmail() {
        createUser(fakeName, "@gmail.com", "123456", false)
        jsonResponse = response!!.then().log().all()
        val message = jsonResponse.extract().path<String>("email")
        Assert.assertEquals(getProp("invalid-email"), message)
    }

}
package restapitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.BASE_URL;
import static utils.Endpoints.CREATE_NEW_EMPLOYEE_ENDPOINT;
import static utils.JSONRequests.*;

public class CreateUserTests {
    @Test
    public void correctDataReturned_when_createUser() {
        Response response = given()
                .baseUri(BASE_URL)
                .body(String.format(CREATE_USER_BODY, employeeName, employeeSalary, employeeAge))
                .contentType("application/json")
                .when()
                .post(CREATE_NEW_EMPLOYEE_ENDPOINT);

        String message = response.jsonPath().getString("message");

        Assert.assertEquals(response.statusCode(), OK_STATUS_CODE);
        Assert.assertEquals(employeeName, response.jsonPath().getString("data.name"));
        Assert.assertEquals(employeeSalary, response.jsonPath().getString("data.salary"));
        Assert.assertEquals(employeeAge, response.jsonPath().getString("data.age"));
        Assert.assertEquals(CREATE_USER_MESSAGE, message);
    }

}

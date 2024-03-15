package restapitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.BASE_URL;
import static utils.Endpoints.UPDATE_EMPLOYEE_ENDPOINT;
import static utils.JSONRequests.*;

public class UpdateUserTests {
    @Test
    public void correctDataReturned_when_updateUser() {
        Response response = given()
                .pathParam("id", deleteEmployeeById)
                .baseUri(BASE_URL)
                .body(String.format(CREATE_USER_BODY, updatedEmployeeName, updatedEmployeeSalary, updatedEmployeeAge))
                .contentType("application/json")
                .when()
                .put(UPDATE_EMPLOYEE_ENDPOINT);

        String message = response.jsonPath().getString("message");


        Assert.assertEquals(response.statusCode(), OK_STATUS_CODE);
        Assert.assertEquals(updatedEmployeeName, response.jsonPath().getString("data.name"));
        Assert.assertEquals(updatedEmployeeSalary, response.jsonPath().getString("data.salary"));
        Assert.assertEquals(updatedEmployeeAge, response.jsonPath().getString("data.age"));
        Assert.assertEquals(UPDATE_USER_MESSAGE, message);
    }

}

package restapitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.BASE_URL;
import static utils.Endpoints.DELETE_EMPLOYEE_ENDPOINT;
import static utils.JSONRequests.*;

public class DeleteUserTests {
    @Test
    public void correctDataReturned_when_deleteUser() {
        Response response = given()
                .pathParam("id", deleteEmployeeById)
                .baseUri(BASE_URL)
                .delete(DELETE_EMPLOYEE_ENDPOINT);

        String status = response.jsonPath().getString("status");
        String message = response.jsonPath().getString("message");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(status, REQUEST_STATUS);
        Assert.assertEquals(message, DELETE_USER_MESSAGE);
    }
}

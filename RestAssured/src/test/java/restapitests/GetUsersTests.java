package restapitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.BASE_URL;
import static utils.Endpoints.EMPLOYEES_ENDPOINT;
import static utils.JSONRequests.*;

public class GetUsersTests {

    @Test

    public void correctDataReturned_when_getUsers() {

        Response response = given()
                .baseUri(BASE_URL)
                .get(EMPLOYEES_ENDPOINT);

        String status = response.jsonPath().getString("status");
        String message = response.jsonPath().getString("message");
        int numberOfEmployees = response.jsonPath().getList("data").size();

        Assert.assertEquals(response.statusCode(), OK_STATUS_CODE);
        Assert.assertEquals(numberOfEmployees, EXPECTED_NUMBER_OF_EMPLOYEES);
        Assert.assertEquals(status, REQUEST_STATUS);
        Assert.assertEquals(message, GET_USERS_MESSAGE);
    }

}

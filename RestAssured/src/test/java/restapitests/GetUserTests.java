package restapitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.BASE_URL;
import static utils.Endpoints.EMPLOYEE_ENDPOINT;
import static utils.JSONRequests.employeeId;

public class GetUserTests {

    @Test
    public void correctDataReturned_when_getSingleUserById() {

        Response response = given()
                .pathParam("id", employeeId)
                .baseUri(BASE_URL)
                .get(EMPLOYEE_ENDPOINT);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(String.valueOf(employeeId), response.jsonPath().getString("data.id"));
        Assert.assertNotNull(response.jsonPath().getString("data.employee_name"));
        Assert.assertTrue(response.jsonPath().getInt("data.employee_salary") > 0);

    }

}

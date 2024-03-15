package utils;

public class JSONRequests {

    public static final String REQUEST_STATUS = "success";
    public static final String GET_USERS_MESSAGE = "Successfully! All records has been fetched.";
    public static final String CREATE_USER_MESSAGE = "Successfully! Record has been added.";
    public static final String UPDATE_USER_MESSAGE = "Successfully! Record has been updated.";
    public static final String DELETE_USER_MESSAGE = "Successfully! Record has been deleted";
    public static final int OK_STATUS_CODE = 200;
    public static final int EXPECTED_NUMBER_OF_EMPLOYEES = 24;


    public static final String CREATE_USER_BODY = "{\"name\":\"%s\",\"salary\":\"%s\",\"age\":\"%s\"}";
    public static String employeeName = "John Smith";
    public static String employeeSalary = "12000";
    public static String employeeAge = "36";
    public static String updatedEmployeeName = "Tom Ford";
    public static String updatedEmployeeSalary = "15000";
    public static String updatedEmployeeAge = "38";
    public static int employeeId = 1;
    public static int deleteEmployeeById = 1;


}

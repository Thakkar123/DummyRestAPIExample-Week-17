package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class EmployeePutTest extends TestBase {

    @Test
    public void updateEmployeeInfo(){

        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("Ramesh Patel");
        employeePojo.setSalary("34000");
        employeePojo.setAge("35");

        Response response = given()
                .header("Content-Type","application/json")
                .pathParam("id", 2218)
                .body(employeePojo)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

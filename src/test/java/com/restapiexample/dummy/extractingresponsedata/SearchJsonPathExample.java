package com.restapiexample.dummy.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){

        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        RestAssured.basePath = "/api/v1/employees";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
            }
    //1.verify total records are 24
    @Test
    public void test001() {
        int records = response.extract().path("data.size");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The number of records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. verify data[23].id = 24
    @Test
    public void test002() {
        int id = response.extract().path("data[23].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[23] employee id is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. verify data[23].employee_name = “Doris Wilder”
    @Test
    public void test003() {
        String name = response.extract().path("data[23].employee_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data[23] employee name is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. verify message = “Successfully! All records has been fetched.”
    @Test
    public void test004(){
        String message = response.extract().path("message");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The message is : " + message);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. verify status = success
    @Test
    public void test005() {
        String status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of status is : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. verify id 3 has salary of 86000
    @Test
     public void test006() {
        int salary = response.extract().path("data[2].employee_salary");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The employee id 3 salary is  : " + salary);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. verify employee id 6 has age of 61
    @Test
    public void test007(){
        int age = response.extract().path("data[5].employee_age");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The age of employee id 6 is  : " + age);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. verify employee id 11 name is Jena Gaines
    @Test
    public void test008(){
        String name = response.extract().path("data[10].employee_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The employee id 11 name is  : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
}

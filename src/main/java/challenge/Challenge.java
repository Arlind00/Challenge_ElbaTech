package challenge;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Challenge {


    @Test
    public void test1() {
        String url = "https://www.elba-tech.com/wp-content/plugins/w3-total-cache/pub/js/lazyload.min.js";
        Response response = given().get(url);
        System.out.println("response.statusCode() = " + response.statusCode());
    }


    @Test
    public void test2() {
        String url = "https://www.elba-tech.com/wp-content/uploads/2020/12/favicon-elba-technologies-final.png";
        Response response = given().get(url);
        System.out.println("response.statusCode() = " + response.statusCode());
    }


    @Test
    public void test3() {
        String url = "https://www.elba-tech.com/wp-content/uploads/2020/12/favicon-elba-technologies-final.png";
        Response response = given().get(url);
        System.out.println("response.statusCode() = " + response.statusCode());
    }


    @Test
    public void test4() {
        String url = "http://gmpg.org/xfn/11";
        Response response = given().get(url);
        System.out.println("response.statusCode() = " + response.statusCode());
    }


    @Test
    public void test5() {
        String url = "http://gmpg.org/xfn/11";
        Response response = given().get(url);
        System.out.println("response.statusCode() = " + response.statusCode());
    }








}

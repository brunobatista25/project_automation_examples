package support.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestContext {
    private static RequestSpecification request;
    private static Response response;

    public static void initRequest(){
        RestAssured.useRelaxedHTTPSValidation();
        request = RestAssured.given();
    }

    public static void log(){
        RestAssured.given().then().log().all();
    }

    public static void setPath(String baseUri, String path){
        if ( request == null){
            initRequest();
        }
        request.baseUri(baseUri);
        request.basePath(path);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public static void setHeader(Map<String, String> contentHeader){
       request.headers(contentHeader);
    }

    public static void setDefaultHeader(){

    }

    public static void setBody(String contentBody){
        request.body(contentBody);

    }

    public static void getRequest(){
        response = request.get();

    }

    public static void postRequest(){
        response = request.post();

    }

    public static void setPathParams(Map<String, String> params){
        request.pathParams(params);

    }

    public static void setParams(Map<String, ?> params){
        request.params(params);

    }

    public static void putRequest(){
       response = request.put();

    }

    public static void patchRequest(){
       response = request.patch();

    }

    public static Response getResponse(){
       return response;
    }
}

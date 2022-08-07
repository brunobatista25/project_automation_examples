package support.utils

import io.restassured.specification.RequestSpecification
import io.restassured.RestAssured
import io.restassured.response.Response

object RestContext {
    private var request: RequestSpecification? = null
    @JvmStatic
    var response: Response? = null
        private set

    fun initRequest() {
        RestAssured.useRelaxedHTTPSValidation()
        request = RestAssured.given()
    }

    fun log() {
        RestAssured.given().then().log().all()
    }

    fun setPath(baseUri: String?, path: String?) {
        if (request == null) {
            initRequest()
        }
        request!!.baseUri(baseUri)
        request!!.basePath(path)
        RestAssured.useRelaxedHTTPSValidation()
    }

    fun setHeader(contentHeader: MutableMap<String, String>) {
        request!!.headers(contentHeader)
    }

    fun setDefaultHeader() {}
    fun setBody(contentBody: String?) {
        request!!.body(contentBody)
    }

    fun getRequest() {
        response = request!!.get()
    }

    fun postRequest() {
        response = request!!.post()
    }

    fun setPathParams(params: Map<String?, String?>?) {
        request!!.pathParams(params)
    }

    fun setParams(params: Map<String?, *>?) {
        request!!.params(params)
    }

    fun putRequest() {
        response = request!!.put()
    }

    fun patchRequest() {
        response = request!!.patch()
    }
}
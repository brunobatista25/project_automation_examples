package service

import model.User
import support.utils.RestContext
import support.enums.BaseUri
import support.enums.ApiPath
import java.util.HashMap

object UserService {
    @JvmStatic
    fun createUser(name: String?, email: String?, password: String?, administrador: Boolean?) {
        println(name)
        RestContext.initRequest()
        RestContext.setPath(BaseUri.URLBASE.path, ApiPath.USER.path)
        val header: MutableMap<String, String> = HashMap()
        header["Content-type"] = "application/json"
        RestContext.setHeader(header)
        val user = User(name,email,password,administrador)
        RestContext.setBody(user.toString())
        RestContext.postRequest()
    }
}
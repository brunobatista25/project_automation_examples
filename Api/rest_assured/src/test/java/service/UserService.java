package service;

import io.restassured.response.Response;
import model.User;
import support.enums.ApiPath;
import support.enums.BaseUri;

import java.util.HashMap;
import java.util.Map;

import static support.utils.RestContext.*;

public class UserService {

    static User user;
    public static void createUser(String name, String email, String password, Boolean administrador) {
        initRequest();

        setPath(BaseUri.URLBASE.getPath(), ApiPath.USER.getPath());

        Map<String, String> header = new HashMap<String, String>();
        header.put("Content-type", "application/json");
        setHeader(header);

        Object users = user.builder().nome(name).email(email).password(password).administrador(administrador).build();
        setBody(users.toString());

        postRequest();

    }
}

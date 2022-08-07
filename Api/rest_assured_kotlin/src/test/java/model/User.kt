package model

class User(val name: String?, val email: String?, val password: String?, val administrador: Boolean?) {

    override fun toString(): String {
        return "{\n" +
                "  \"nome\": \"$name\",\n" +
                "  \"email\": \"$email\",\n" +
                "  \"password\": \"$password\",\n" +
                "  \"administrador\": \"$administrador\"\n" +
                "}"
    }
}
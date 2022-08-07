package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {

    @Builder.Default
    private String nome = "bruno";
    @Builder.Default
    private String email = "bruno@gmail.com";
    @Builder.Default
    private String password = "123456";
    @Builder.Default
    private Boolean administrador = false;

    @Override
    public String toString() {
        return "{" + "\n  " +
                "\"nome\""+ ": " + "\"" + nome + "\"" + ",\n " +
                "\"email\""+ ": " + "\"" + email + "\"" + ",\n " +
                "\"password\"" + ": " + "\"" + password + "\"" + ",\n " +
                "\"administrador\""+ ": " + "\"" + administrador + "\"" + "\n" +
                "}";
    }
}

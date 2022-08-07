package support.enums;

public enum ApiPath {
    USER("/usuarios");

    private String path;

    ApiPath(String path){
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

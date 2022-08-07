package support.enums;

import static support.utils.GetProperties.getProp;

public enum BaseUri {
    URLBASE(getProp("urlbase"));

    private String path;

    BaseUri(String path){
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}

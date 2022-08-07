package support.enums

import support.utils.GetProperties

enum class BaseUri(val path: String) {
    URLBASE(GetProperties.getProp("urlbase"));

}
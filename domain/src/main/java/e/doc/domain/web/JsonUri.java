package e.doc.domain.web;

import java.io.Serializable;

public class JsonUri implements Serializable {
    Boolean absolute;
    String authority;
    String fragment;
    String host;
    Boolean opaque;
    String path;
    int port;
    String query;
    String rawAuthority;
    String rawFragment;
    String rawPath;
    String rawQuery;
    String rawSchemeSpecificPart;
    String rawUserInfo;
    String scheme;
    String schemeSpecificPart;
    String userInfo;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean getOpaque() {
        return opaque;
    }

    public void setOpaque(Boolean opaque) {
        this.opaque = opaque;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRawAuthority() {
        return rawAuthority;
    }

    public void setRawAuthority(String rawAuthority) {
        this.rawAuthority = rawAuthority;
    }

    public String getRawFragment() {
        return rawFragment;
    }

    public void setRawFragment(String rawFragment) {
        this.rawFragment = rawFragment;
    }

    public String getRawPath() {
        return rawPath;
    }

    public void setRawPath(String rawPath) {
        this.rawPath = rawPath;
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public void setRawQuery(String rawQuery) {
        this.rawQuery = rawQuery;
    }

    public String getRawSchemeSpecificPart() {
        return rawSchemeSpecificPart;
    }

    public void setRawSchemeSpecificPart(String rawSchemeSpecificPart) {
        this.rawSchemeSpecificPart = rawSchemeSpecificPart;
    }

    public String getRawUserInfo() {
        return rawUserInfo;
    }

    public void setRawUserInfo(String rawUserInfo) {
        this.rawUserInfo = rawUserInfo;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getSchemeSpecificPart() {
        return schemeSpecificPart;
    }

    public void setSchemeSpecificPart(String schemeSpecificPart) {
        this.schemeSpecificPart = schemeSpecificPart;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}

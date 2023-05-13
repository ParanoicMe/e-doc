package e.doc.domain.web;

import java.io.Serializable;

public class JsonUrl implements Serializable {

    String authority;
    Object content;
    int defaultPort;
    String file;
    String host;
    String path;
    int port;
    String protocol;
    String query;
    String ref;
    String userInfo;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getDefaultPort() {
        return defaultPort;
    }

    public void setDefaultPort(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "JsonUrl{" +
                "authority='" + authority + '\'' +
                ", content=" + content +
                ", defaultPort=" + defaultPort +
                ", file='" + file + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", port=" + port +
                ", protocol='" + protocol + '\'' +
                ", query='" + query + '\'' +
                ", ref='" + ref + '\'' +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}

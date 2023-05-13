package e.doc.domain.web;

import java.io.Serializable;
import java.util.Arrays;

public class JsonExportResponce implements Serializable {
    String description;
    JsonFile file;
    String filename;
    Object inputStream;
    Boolean open;
    Object outputStream;
    String path;
    Boolean readable;
    JsonUri uri;
    JsonUrl url;
    Boolean writable;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JsonFile getFile() {
        return file;
    }

    public void setFile(JsonFile file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Object getInputStream() {
        return inputStream;
    }

    public void setInputStream(Object inputStream) {
        this.inputStream = inputStream;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Object getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(Object outputStream) {
        this.outputStream = outputStream;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public JsonUri getUri() {
        return uri;
    }

    public void setUri(JsonUri uri) {
        this.uri = uri;
    }

    public JsonUrl getUrl() {
        return url;
    }

    public void setUrl(JsonUrl url) {
        this.url = url;
    }

    public Boolean getWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    @Override
    public String toString() {
        return "JsonExportResponce{" +
                "description='" + description + '\'' +
                ", file=" + file +
                ", filename='" + filename + '\'' +
                ", inputStream=" + inputStream +
                ", open=" + open +
                ", outputStream=" + outputStream +
                ", path='" + path + '\'' +
                ", readable=" + readable +
                ", uri=" + uri +
                ", url=" + url +
                ", writable=" + writable +
                '}';
    }
}

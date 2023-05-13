package e.doc.domain.web;

import java.io.Serializable;

public class JsonFile implements Serializable {
    Boolean absolute;
    String absolutePath;
    String canonicalPath;
    Boolean directory;
    Boolean file;
    int freeSpace;
    Boolean hidden;
    String name;
    String parent;
    String path;
    int totalSpace;
    int usableSpace;

    public Boolean getAbsolute() {
        return absolute;
    }

    public void setAbsolute(Boolean absolute) {
        this.absolute = absolute;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getCanonicalPath() {
        return canonicalPath;
    }

    public void setCanonicalPath(String canonicalPath) {
        this.canonicalPath = canonicalPath;
    }

    public Boolean getDirectory() {
        return directory;
    }

    public void setDirectory(Boolean directory) {
        this.directory = directory;
    }

    public Boolean getFile() {
        return file;
    }

    public void setFile(Boolean file) {
        this.file = file;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(int totalSpace) {
        this.totalSpace = totalSpace;
    }

    public int getUsableSpace() {
        return usableSpace;
    }

    public void setUsableSpace(int usableSpace) {
        this.usableSpace = usableSpace;
    }

    @Override
    public String toString() {
        return "JsonFile{" +
                "absolute=" + absolute +
                ", absolutePath='" + absolutePath + '\'' +
                ", canonicalPath='" + canonicalPath + '\'' +
                ", directory=" + directory +
                ", file=" + file +
                ", freeSpace=" + freeSpace +
                ", hidden=" + hidden +
                ", name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                ", path='" + path + '\'' +
                ", totalSpace=" + totalSpace +
                ", usableSpace=" + usableSpace +
                '}';
    }
}

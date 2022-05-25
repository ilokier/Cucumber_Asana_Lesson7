package Models;

public class Workspace {
    private String gid;
    private String name;
    private String resource_type;

    public Workspace(String gid, String name, String resource_type) {
        this.gid = gid;
        this.name = name;
        this.resource_type = resource_type;
    }

    public Workspace() {
    }

    public String getGid() {
        return gid;
    }

    public String getName() {
        return name;
    }

    public String getResource_type() {
        return resource_type;
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "gid='" + gid + '\'' +
                ", name='" + name + '\'' +
                ", resource_type='" + resource_type + '\'' +
                '}';
    }
}

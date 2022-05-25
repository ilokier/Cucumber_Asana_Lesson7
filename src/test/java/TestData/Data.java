package TestData;

public class Data {
    private String baseURI;
    private String workspacesPath;
    private int getStatusCode;
    private String token;

    public String getBaseURI() {
        return baseURI;
    }

    public String getWorkspacesPath() {
        return workspacesPath;
    }

    public int getGetStatusCode() {
        return getStatusCode;
    }

    public String getToken() {
        return token;
    }

    public Data(String baseURI, String workspacesPath, int getStatusCode, String token) {
        this.baseURI = baseURI;
        this.workspacesPath = workspacesPath;
        this.getStatusCode = getStatusCode;
        this.token = token;
    }

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "baseURI='" + baseURI + '\'' +
                ", workspacesPath='" + workspacesPath + '\'' +
                ", getStatusCode=" + getStatusCode +
                ", token='" + token + '\'' +
                '}';
    }
}

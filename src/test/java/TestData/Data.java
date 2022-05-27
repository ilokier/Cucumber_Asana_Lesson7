package TestData;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
    private String baseURI;
    private String workspacesPath;
    private String projectsPath;
    private String projectInWorkspacePath;
    private int getStatusCode;
    private int postStatusCode;
    private String token;
}



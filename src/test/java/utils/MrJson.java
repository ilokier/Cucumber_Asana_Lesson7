package utils;

import Models.Project;
import Models.Workspace;
import TestData.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class MrJson {
    private static Logger logger = LoggerFactory.getLogger("MrJson.class");
    private static Data data;
    private static Workspace workspace;
    private static Project project;

    public static Data readData(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(Paths.get(path).toFile(), Data.class);
            logger.info("<<<<<<<<<Data: " + data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static Workspace readWorkspace(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            workspace = mapper.readValue(Paths.get(path).toFile(), Workspace.class);
            logger.info("<<<<<<<<Workspace: " + workspace);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return workspace;
    }

    public static Project readProject(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            project = mapper.readValue(Paths.get(path).toFile(), Project.class);
            logger.info("<<<<<<<<Project: " + project);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return project;
    }
}

package utils;

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
}

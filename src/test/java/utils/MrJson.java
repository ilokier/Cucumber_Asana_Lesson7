package utils;

import Models.Workspace;
import TestData.Data;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class MrJson {
    private static Data data;
    private static Workspace workspace;

    public static Data readData(File file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(file, Data.class);
            System.out.println("<<<<<<<<<Data: " + data);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return data;
    }

    public static Workspace readWorkspace(File file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            workspace = mapper.readValue(file, Workspace.class);
            System.out.println("<<<<<<<<Workspace: " + workspace);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return workspace;
    }
}

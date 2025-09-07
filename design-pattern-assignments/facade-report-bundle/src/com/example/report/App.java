package com.example.report;
import java.nio.file.*; import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        Path outDir = Path.of("out");
        ReportBundleFacade.export(data, outDir, "report1");    
    }
}

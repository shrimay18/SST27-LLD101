package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    public static Path export(Map<String,Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");

        JsonWriter jw = new JsonWriter(); 
        Zipper z = new Zipper(); 
        AuditLog log = new AuditLog();

        Path json = jw.write(data, outDir, baseName);
        Path zip = z.zip(json, outDir.resolve(baseName + ".zip"));
        log.log("exported " + zip);

        System.out.println("DONE " + zip);
        return zip;
    }
}

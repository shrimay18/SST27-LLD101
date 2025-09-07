package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) throw new IllegalArgumentException("inFile and outFile required");
        Path inFile = Path.of(args[0]);
        Path outFile = Path.of(args[1]);

        VideoPipelineFacade.process(inFile, outFile, true, 0.5, null);
        System.out.print("Processing OK (wire the facade to complete).");
    }
}

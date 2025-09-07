package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    public static Path process(Path inFile, Path outFile, boolean gray, Double scale, Integer sharpenStrength) {
        Decoder dec = new Decoder();
        FilterEngine fe = new FilterEngine();
        Encoder enc = new Encoder();

        // Step 1: Decode
        Frame[] frames = dec.decode(inFile);

        // Step 2: Optional grayscale
        if (gray) {
            frames = fe.grayscale(frames);
        }

        // Step 3: Optional scale
        if (scale != null) {
            frames = fe.scale(frames, scale);
        }

        // Step 4: Optional sharpen via adapter
        if (sharpenStrength != null) {
            LegacySharpen legacy = new LegacySharpen();
            VideoFilter sharpen = new SharpenAdapter(legacy);
            // simulate frames → string handle
            String handle = "HANDLE:frames";
            String sharpenedHandle = sharpen.apply(handle);
            System.out.println("Applied sharpen: " + sharpenedHandle);
            // (you could map this back to frames if needed, here simulation is enough)
        }

        // Step 5: Encode
        Path out = enc.encode(frames, outFile);
        System.out.println("Wrote " + out);
        return out;
    }
}

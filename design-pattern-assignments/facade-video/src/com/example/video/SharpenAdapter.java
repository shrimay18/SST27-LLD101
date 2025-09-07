package com.example.video;

public class SharpenAdapter implements VideoFilter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = legacy;
    }

    @Override
    public String apply(String framesHandle) {
        // Use a fixed strength for this example
        return legacy.applySharpen(framesHandle, 5);
    }
    
}

package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private volatile Properties props = new Properties();
    private static volatile AppSettings instance; // instance variable
    private AppSettings() { 
        if(instance != null) {
            throw new IllegalStateException("Already initialized. Use getInstance().");
        }
    } // should not be public for true singleton

    public static AppSettings getInstance() {
        if(instance == null){
            synchronized (AppSettings.class) {
                if(instance == null){ // double-checked locking 
                    instance = new AppSettings();   
                }
            }
        }

        return instance; // returns a fresh instance (bug)
    }

    public void loadFromFile(Path file) {
        Properties newProps = new Properties();
        try (InputStream in = Files.newInputStream(file)) {
            newProps.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        this.props = newProps; // atomic switch
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}

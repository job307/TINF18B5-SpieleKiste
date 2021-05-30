package main.bb.loaders;

import java.io.InputStream;

/**
 * A class that describes the loading of game resources
 */
public class ResourceLoader
{
    public static InputStream load(final String path) {
        InputStream input = ResourceLoader.class.getResourceAsStream(path);
        if (input == null) {
            input = ResourceLoader.class.getResourceAsStream("/" + path);
        }
        return input;
    }
}
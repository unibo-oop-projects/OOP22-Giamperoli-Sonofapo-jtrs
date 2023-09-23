package it.unibo.jtrs.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * An utility class to load custom resources.
 */
public final class ResourceLoader {

    private ResourceLoader() { }

    /**
     * Return an InputStream to a given file.
     *
     * @param fileName the file name
     * @return the InputStream of the file
     * @throws IOException if that resource can not be found
     */
    public static InputStream load(final String fileName) throws IOException {
        var resource = ResourceLoader.class.getResourceAsStream("/" + fileName);
        if (resource == null) {
            throw new IOException("Can not load " + fileName);
        }
        return resource;
    }
}

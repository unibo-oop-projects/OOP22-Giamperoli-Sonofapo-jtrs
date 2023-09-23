package it.unibo.jtrs.utils;

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
     */
    public static InputStream load(final String fileName) {
        return ResourceLoader.class.getResourceAsStream("/" + fileName);
    }
}

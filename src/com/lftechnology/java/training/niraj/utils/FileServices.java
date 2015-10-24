package com.lftechnology.java.training.niraj.utils;

import java.io.IOException;

/**
 * Services related to file processing
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public interface FileServices {
    /**
     * Reads content of a file
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return String
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String readFile() throws IOException;

    /**
     * Writes content to a file
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean writeFile(String s) throws IOException;
}

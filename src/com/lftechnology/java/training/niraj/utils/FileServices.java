package com.lftechnology.java.training.niraj.utils;

import java.io.FileNotFoundException;
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
    public String readFile() throws FileNotFoundException, IOException;

    /**
     * Writes content to a file
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean writeFile(String s) throws FileNotFoundException, IOException;
}

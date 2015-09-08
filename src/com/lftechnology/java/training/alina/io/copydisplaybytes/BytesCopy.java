package com.lftechnology.java.training.alina.io.copydisplaybytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The first programming exercise is to write a simple program which reads byte data from a file from an InputStream and display it in
 * console and writes each byte to a file using OutputStream.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class BytesCopy {

    private static final Logger LOGGER = Logger.getLogger(BytesCopy.class.getName());
    private static String inFileStr = "src/com/lftechnology/java/training/alina/io/copydisplaybytes/files/bytefile.txt";
    private static String outFileStr = "src/com/lftechnology/java/training/alina/io/copydisplaybytes/files/bytecopyfile.txt";

    private BytesCopy() {

    }

    /**
     * Main Method consists of reading byte data from a file and writes each byte to a file
     * 
     * @param args
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void main(String[] args) {
        try (FileInputStream reader = new FileInputStream(inFileStr); FileOutputStream writer = new FileOutputStream(outFileStr)) {
            LOGGER.log(Level.INFO, "Total file size to read (in bytes) : {0}", new Object[] { reader.available() });
            String fileContent = getFileContent(reader, writer);
            LOGGER.log(Level.INFO, "{0}", new Object[] { fileContent });
        } catch (FileNotFoundException fnfe) {
            LOGGER.log(Level.WARNING, "File not found : {0}", new Object[] { fnfe });
        } catch (IOException ioe) {
            LOGGER.log(Level.WARNING, "IOException : {0}", new Object[] { ioe });
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
        }
    }

    /**
     * Gets the contents from a file
     * 
     * @param reader
     *            {@link FileInputStream}
     * @param writer
     *            {@link FileOutputStream}
     * @return fileContent {@link String} file contents
     * @throws IOException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static String getFileContent(FileInputStream reader, FileOutputStream writer) throws IOException {
        BytesData bytes = new BytesData();
        bytes.setBuffer(new byte[1024]);
        String fileContent = bytes.readWriteByteData(reader, writer);
        return fileContent;
    }
}

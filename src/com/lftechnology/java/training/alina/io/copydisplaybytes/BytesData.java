package com.lftechnology.java.training.alina.io.copydisplaybytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BytesData Class consists of read write byte data functions
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class BytesData {
    byte[] buffer;
    int length;

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Reads/Writes data from/to a file
     * 
     * @param reader
     *            {@link FileInputStream}
     * @param writer
     *            {@link FileOutputStream}
     * @return {@link String} file contents
     * @throws IOException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public String readWriteByteData(FileInputStream reader, FileOutputStream writer) throws IOException {
        while ((length = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, length);
        }
        return this.toString();
    }

    @Override
    public String toString() {
        return "File content : " + new String(buffer);
    }
}

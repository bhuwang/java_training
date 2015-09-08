/**
 * 
 */
package com.lftechnology.java.training.niraj.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File Service Implementation
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class FileServiceImpl implements FileServices {
    private BufferedReader inputStream = null;
    private BufferedWriter outputStream = null;
    private String filePath;

    public FileServiceImpl(String filePath) {
        setFilePath(filePath);
    }

    public BufferedReader getInputStream() {
        return inputStream;
    }

    public void setInputStream(BufferedReader inputStream) {
        this.inputStream = inputStream;
    }

    public BufferedWriter getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(BufferedWriter outputStream) {
        this.outputStream = outputStream;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readFile() throws FileNotFoundException, IOException {
        StringBuilder fileContent = new StringBuilder();
        try {
            inputStream = new BufferedReader(new FileReader(filePath));
            char character;
            int content;
            while ((content = inputStream.read()) != -1) {
                character = (char) content;
                fileContent.append(character);
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw e;
                }
            }

        }
        return fileContent.toString();

    }

    @Override
    public boolean writeFile(String content) throws FileNotFoundException, IOException {
        boolean status = false;
        try {
            outputStream = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < content.length(); i++) {
                byte charAscii = (byte) content.charAt(i);
                outputStream.write(charAscii);
            }
            status = true;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        return status;
    }
}

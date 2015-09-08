package com.lftechnology.java.training.niraj.countcharacter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.utils.FileServiceImpl;

/**
 * Counts occurance of character in a string
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class CountCharacter {
    private static final Logger LOGGER = Logger.getLogger(CountCharacter.class.getName());
    private static final String NO_CONTENT = "No File Content";
    private String readFilePath;
    private String writeFilePath;

    private CountCharacter(String readPath, String writePath) {
        setReadFilePath(readPath);
        setWriteFilePath(writePath);

    }

    public String getReadFilePath() {
        return readFilePath;
    }

    public void setReadFilePath(String readFilePath) {
        this.readFilePath = readFilePath;
    }

    public String getWriteFilePath() {
        return writeFilePath;
    }

    public void setWriteFilePath(String writeFilePath) {
        this.writeFilePath = writeFilePath;
    }

    public static void main(String[] args) {
        try {
            String readPath = "src/com/lftechnology/java/training/niraj/countcharacter/files/characters.txt";
            String writePath = "src/com/lftechnology/java/training/niraj/countcharacter/files/character-count.txt";
            CountCharacter countChar = new CountCharacter(readPath, writePath);
            String fileContent = countChar.readFileContent();
            Map<Character, Integer> charCount = countChar.getCharacterCount(fileContent);
            LOGGER.log(Level.INFO, "{0}", charCount);
            if(countChar.writeToFile(charCount.toString())){
             LOGGER.info("Successfully added the character count to the file");   
            }else{
                LOGGER.severe("Failed to add the character count to the file");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unknown Exception:{0}", e);
        }
    }

    /**
     * Reads File content
     * 
     * @author Niraj Rajbhandari <nirajrajbahndari@lftechnology.com>
     * @return {@link String} content of a file
     */
    private String readFileContent() {
        FileServiceImpl fileService = new FileServiceImpl(readFilePath);
        String fileContent = NO_CONTENT;
        try {
            fileContent = fileService.readFile();
        } catch (IOException ie) {
            LOGGER.log(Level.SEVERE, "IOException:{0}", ie);
        }
        return fileContent;
    }

    private boolean writeToFile(String content) {
        boolean status = false;
        try {
            FileServiceImpl fileService = new FileServiceImpl(writeFilePath);
            status = fileService.writeFile(content);
        } catch (IOException ie) {
            LOGGER.log(Level.SEVERE, "IOException:{0}", ie);
        }
        return status;

    }

    /**
     * Gets characters in a string as an array
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param s
     *            String
     * @return array of {@link Character}
     */
    private char[] getCharacterListInString(String s) {
        char[] charList = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charList[i] = s.charAt(i);
        }
        return charList;
    }

    /**
     * Gets list of characters with their occurance
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param s
     *            String
     * @return {@link Map} with a list of characters and their occurance count
     */
    private Map<Character, Integer> getCharacterCount(String s) {
        char[] charList = this.getCharacterListInString(s);
        Map<Character, Integer> characterCount = new LinkedHashMap<Character, Integer>();
        char character;
        int count;
        for (int i = 0; i < charList.length; i++) {
            character = charList[i];
            if (Character.isLetter(character)) {
                if (!characterCount.containsKey(character)) {
                    characterCount.put(character, 1);
                } else {
                    count = characterCount.get(character);
                    count++;
                    characterCount.put(character, count);
                }
            }

        }
        return characterCount;

    }

}

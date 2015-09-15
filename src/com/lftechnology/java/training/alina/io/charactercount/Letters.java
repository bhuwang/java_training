package com.lftechnology.java.training.alina.io.charactercount;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Letters class consists of functions like count characters and case conversions
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Letters {
    private char letter;
    private String line;
    private int occurs;

    public Letters() {
    }

    public Letters(char letter) {
        this.setLetter(letter);
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getOccurs() {
        return occurs;
    }

    public void setOccurs(int occurs) {
        this.occurs = occurs;
    }

    /**
     * Function used to count the no. of characters
     * 
     * @param reader
     *            {@link BufferedReader}
     * @return {@link String} total character count
     * @throws IOException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public String getCountOfCharacters(BufferedReader reader) throws IOException {
        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (letter == convertUpperToLowerCase(line.charAt(i))) {
                    occurs++;
                }
            }
        }
        return this.toString();
    }

    /**
     * Used to convert upper case to lower case
     * 
     * @param currentLetter
     *            {@link Character}
     * @return {@link Character} returns characters in lower case
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private char convertUpperToLowerCase(char currentLetter) {
        char toLower = currentLetter;
        if (Character.isUpperCase(toLower)) {
            toLower = Character.toLowerCase(toLower);
        }
        return toLower;
    }

    @Override
    public String toString() {
        return "File has " + this.occurs + " instances of letter " + letter;
    }
}

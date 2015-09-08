
package com.lftechnology.java.training.krishna.io.countcharacter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This program reads the integer data from given file
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ReadIntFromFile {

	private static final Pattern COMMA = Pattern.compile(",");

	//constructor
	private ReadIntFromFile() {

	}

	/**
	 * This method computes the no. of character occurrence from given file.
	 * 
	 * @param filePath
	 *            {@link String}
	 * @return count {@link int} no. of character occurrence
	 * @throws IOException
	 *             if an I/O error occurs
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static BufferedReader openFile(String filePath)
		throws IOException {

		return new BufferedReader(new FileReader(filePath));

	}

	/**
	 * This method release buffer reader resource.
	 * 
	 * @param reader
	 *            {@link BufferedReader}
	 * @throws IOException
	 *             if an I/O error occurs
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void closeFile(BufferedReader reader)
		throws IOException {

		reader.close();

	}

	/**
	 * This method read the integer from buffer reader.
	 * 
	 * @param reader
	 *            {@link BufferedReader}
	 * @return intList {@link List}
	 * @throws IOException
	 *             if an I/O error occurs
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static List<Integer> readLine(BufferedReader reader)
		throws IOException {

		String line;
		List<Integer> intList = new ArrayList<Integer>();
		while ((line = reader.readLine()) != null) {
			for (String token : COMMA.split(line)) {
				try {
					intList.add(Integer.parseInt(token));
				}
				catch (NumberFormatException ex) {
					continue;

				}
			}
		}
		return intList;
	}

	/**
	 * This method read the content from given file.
	 * 
	 * @param filePath
	 *            {@link String}
	 * @return sb {@link StringBuilder}
	 * @throws IOException
	 *             if an I/O error occurs
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static String readFile(String filePath)
		throws IOException {

		BufferedReader br = openFile(filePath);
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		}
		finally {
			br.close();
		}
	}

}
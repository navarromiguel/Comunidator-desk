package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	// Read file and return a String List
	public static List<String> read(String fileName) throws IOException{
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
		    String line = br.readLine();

		    while (line != null) {
		    	lines.add(line);
		        line = br.readLine();
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    br.close();
		}
		return lines;
	}
	
	// Appends new line to file
	public static void appendLine(String fileName, String text) throws IOException{
		Writer output = new BufferedWriter(new FileWriter(fileName, true));
		output.write(text + "\n");
		output.close();
	}
	
	// Prints the content of the file on the terminal
	public static void printFile(String fileName) {
		List<String> list = new ArrayList<String>();
		try {
			list = read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String s : list) {
			System.out.println(s);
		}
	}
}

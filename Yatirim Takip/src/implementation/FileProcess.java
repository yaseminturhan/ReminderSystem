package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileProcess {

	public void writeFile(String fileName, String line) {
		BufferedWriter bufferedWriter;
		try {

			bufferedWriter = new BufferedWriter(this.getFileWriter(fileName));
			bufferedWriter.append(line);
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(String fileName, ArrayList<String> lines) {
		BufferedWriter bufferedWriter;
		try {
			bufferedWriter = new BufferedWriter(this.getFileWriter(fileName));
			for(String line : lines ) {
				bufferedWriter.append(line);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteLine(String fileName, String id) {
		BufferedWriter bufferedWriter;
		ArrayList<String> lines = this.readLinesExceptId(fileName, id);
		File file = new File(fileName);
		file.delete();
		writeFile(fileName, lines);
	}

	private ArrayList<String> readLinesExceptId(String fileName, String id) {
		ArrayList<String> lines = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(this.getFileReader(fileName));
			String line;
			while((line = bufferedReader.readLine()) != null) {
				if(!line.split("___")[0].equals(id)) {
					lines.add(line);
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public ArrayList<String> readLines(String fileName) {
		ArrayList<String> lines = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(this.getFileReader(fileName));
			String line;
			while((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public int getLastId(String fileName) {
		int lastId = 0;
		try {
			BufferedReader bufferedReader = new BufferedReader(this.getFileReader(fileName));
			String line;
			while((line = bufferedReader.readLine()) != null){
				lastId++;
			}
			bufferedReader.close();
			return ++lastId;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private FileReader getFileReader(String fileName) throws IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		return new FileReader(file.getAbsoluteFile());
	}
	
	private FileWriter getFileWriter(String fileName) throws IOException {
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
		return new FileWriter(file.getAbsoluteFile(), true);
	}
	
}

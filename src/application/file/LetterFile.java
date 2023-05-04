package application.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LetterFile {
	private static final String ROOT_FOLDER = "OUTPUT-FILES/letters";
	private static final String FILE_NAMES_PATH = ROOT_FOLDER + File.separator + "file-names-list.txt";


	//for pdf export didnt do
	public static String read(String fileName) {
		String content = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null) {
					// end of file
					break;
				}
				content += line + "\n";
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
				}
			}
		}
		return content;
	}

	public static String save(String firstName, String lastName, String content, String fileName) {

		boolean createFile = false;
		if (fileName == null) {
			// create file
			createFile = true;
		}
		if (createFile) {
			fileName = getFileName(firstName, lastName);
		}
		String filePath = getFilePath(fileName);

		writeToFile(content, filePath);

		if (createFile) {
			// new file created
			addFileToList(fileName);
		}
		return fileName;
	}

	private static String getFilePath(String fileName) {
		String filePath = ROOT_FOLDER + File.separator + fileName;
		return filePath;
	}

	public static String getFileName(String firstName, String lastName) {
		List<String> fileNamesList = getFileNamesList();

		String fileName;
		int count = 0;
		while (true) {
			count++;

			fileName = firstName + "-" + lastName + "-" + count;
			File f = new File(fileName);
			if (f.exists() || fileNamesList.contains(fileName)) {
				continue;
			} else {
				// file does not exist. use the name.
				break;
			}

		} // while

		return fileName;
	}

	private static void writeToFile(String content, String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fileName));
			pw.println(content);
			pw.flush();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
			if (pw != null) {
				pw.close();
			}
		}
	}

	private static void addFileToList(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(FILE_NAMES_PATH, true));
			pw.println(fileName);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
			if (pw != null) {
				pw.close();
			}
		}

	}

	public static List<String> getFileNamesList() {
		List<String> list = new ArrayList<>();
		File file = new File(FILE_NAMES_PATH);
		if (!file.exists()) {
			return list;
		}
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null) {
					// end of file
					break;
				}
				list.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			if (br != null) {
				try {
					br.close();
				} catch (IOException e1) {
				}
			}
		}
		return list;

	}

	public static boolean deleteFile(String fileName) {
		String filePath = getFilePath(fileName);
		File f = new File(filePath);
		boolean deleteOK = false;
		if (f.exists()) {
			deleteOK = f.delete();
			if (deleteOK) {
				RecommendationObjectFile.deleteFile(fileName);
				deleteFromFileList(fileName);
			}

		}
		return deleteOK;

	}

	private static void deleteFromFileList(String fileName) {
		List<String> list = getFileNamesList();
		if (list == null || list.isEmpty()) {
			return;
		}
		list.remove(fileName);

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
			sb.append("\n");

		}

		String content = sb.toString();
		writeToFile(content, FILE_NAMES_PATH);

	}

}

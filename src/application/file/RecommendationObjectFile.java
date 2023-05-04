package application.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import application.model.Recommendation;

public class RecommendationObjectFile {
	private static final String ROOT_FOLDER = "OUTPUT-FILES/objects";

	public static void save(Recommendation rec) {
		String fileName = getFilePath(rec.getFileName());
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(rec);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static Recommendation read(String fileName) {
		Recommendation rec = null;

		String filePath = getFilePath(fileName);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));

			rec = (Recommendation) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return rec;
	}

	private static String getFilePath(String fileName) {
		String filePath = ROOT_FOLDER + File.separator + fileName;
		return filePath;
	}

	public static void deleteFile(String fileName) {
		String filePath = getFilePath(fileName);
		File f = new File(filePath);
		if (f.exists()) {
			f.delete();
		}
	}
}

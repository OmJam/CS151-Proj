package application.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import application.model.Profile;

public class ProfileObjectFile {
	private static final String ROOT_FOLDER = "OUTPUT-FILES/profiles/";

	public static void save(Profile p) {
		String fileName = getFilePath();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(p);
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

	public static Profile read() {
		Profile p = null;

		String filePath = getFilePath();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filePath));

			p = (Profile) ois.readObject();
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

		return p;
	}

	private static String getFilePath() {
		String filePath = ROOT_FOLDER + File.separator + "profile.object";
		return filePath;
	}

}

package org.jagan.filesystem;

import java.io.File;

public class FileRenameUtil {

	public static void main(String[] args) {
		
		String pathName = "C:\\Songs\\JaJe downloads\\Gin";
		String name = "Gin";
		File folder = new File(pathName);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                String fileName = listOfFiles[i].getName();
				File f = new File(pathName + "\\" + fileName);
				String newFileName = pathName + "\\" + name + " - " + fileName;
				f.renameTo(new File(newFileName));
                //System.out.println("New Name : " + newFileName);
            }
        }
	}
}

package org.jagan.filesystem;

import java.io.File;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

public class MP3FileTagEditUtil {

	public static void main(String[] args) {
		
		//String dirName = args[0];
		//String folderName = args[1];

		String dirName = "C:\\Songs\\New Folder\\Hindi";
		String folderName = "The Legend Of Bhagat Singh";
		
		String pathName = dirName + "\\" + folderName;
		File folder = new File(pathName);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String fileName = listOfFiles[i].getName();
                setTags(pathName, folderName, fileName);
                File f = new File(pathName + "\\" + fileName);
                f.delete();
            }
        }		
	}

	private static void setTags(String pathName, String prefix, String fileName) {
		try {
			Mp3File mp3file = new Mp3File(pathName + "\\" + fileName);
			if(mp3file.hasId3v2Tag()) {
				ID3v2 id3v2Tag =  mp3file.getId3v2Tag();
				
				String newTitle = id3v2Tag.getTitle().replaceAll(" - MyMp3Song.com", "");
				id3v2Tag.setTitle(newTitle);
				
				String newContributingArtists = id3v2Tag.getArtist().replaceAll("A R Rahman", "A.R.Rahman");
				id3v2Tag.setArtist(newContributingArtists);
				
				id3v2Tag.setAlbum(prefix);
				
				//id3v2Tag.setCopyright(" ");
				
				String name = fileName.substring(0);
				//String name = fileName.replaceAll(" - www.downloadming.com", "").replaceAll("_", " ");
				
				String newFileName = pathName + "\\" + prefix + " - " + name;
				
				mp3file.save(newFileName);
				System.out.println("Done For New File name " + newFileName);
			}

		} catch(Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
}

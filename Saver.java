package com.chessgame.main;

import java.io.File;
import java.io.IOException;

public class Saver {
	File foundIn = null;
	private static File gameDir = makeGameFolder();;
	
	private static Integer move = 1; 
	
	public Saver() {
		
	}
	
	public static void saveMove() {
		File move = new File(gameDir.getAbsolutePath() + "/" + Saver.move.toString() + ".txt");
		
		try {
			move.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Saver.move++;
	}
	
	private static File makeGameFolder() {
		Integer num = 1;
		boolean created = false;
		File dir = new File ("C:/Users/Student");
		File tempDir = null;
		
		while(!created){
			File toCreate = new File ("C:/Users/Student/Game" + num.toString());
			if(!dirExist("Game" + num.toString(), dir)) {
				created = toCreate.mkdir();
				tempDir = toCreate;
			}
			num++;
		}
		
		return tempDir;
	}
	
	public File findFile(String name, File dir) {
		File[] list = dir.listFiles();
       
		if(list!=null)
        	for (File fil : list)
            {
        		if (fil.isDirectory())
                {
                    findFile(name,fil);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    foundIn = fil.getParentFile();
                }
            }
        return foundIn;
	}
	
	public static boolean dirExist(String name, File dir) {
		File[] list = dir.listFiles();
		if(list!=null)
        	for (File fil : list)
            {
        		if (fil.isDirectory() && fil.getName().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
		
		return false;
	}
}
package resources;

import java.io.File;

public class FolderCreation {

	

	public static void main(String[] args) {
		
		File file = new File(".\\src\\test\\java\\TestResults\\Verifys");
		file.mkdir();

	}

}

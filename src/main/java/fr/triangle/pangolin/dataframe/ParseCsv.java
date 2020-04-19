package fr.triangle.pangolin.dataframe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseCsv {
	static File file;
	static Scanner scannerLigne;
	static Scanner scannerAttribue;
	static List<String> listeLabel;

	public static Object[][] parce(String csvFile){
		
		file = new File(csvFile);
		ArrayList<String[]> liste = new ArrayList<String[]>();
		
		try {
			scannerLigne = new Scanner(file);
		} catch (Exception e) {
			System.err.println("Fichier non existant");
		}
		
		scannerLigne = scannerLigne.useDelimiter("\n");
		String ligne = scannerLigne.next();		
		liste.add(ligne.split(";"));
		while(scannerLigne.hasNext()) {
			ligne = scannerLigne.next();
			liste.add(ligne.split(";"));
		}
		return (Object[][]) liste.toArray();
	}
}

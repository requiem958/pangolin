package fr.triangle.pangolin.dataframe;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ParseCsv {
	static File file;
	static Scanner scannerLigne;
	static Scanner scannerAttribue;
	static List<String> listeLabel;
	public static void parce(String csvFile, Dataframe data){
		
		file = new File(csvFile);
		
		try {
			scannerLigne = new Scanner(file);
		} catch (Exception e) {
			System.err.println("Fichier non existant");
		}
		
		scannerLigne = scannerLigne.useDelimiter("\n");
		
		String ligne = scannerLigne.next();
		String[] tab = ligne.split(";");
		
		for(int i = 0; i<tab.length; i++) {
			listeLabel.add(tab[i]);
		}
		
		ligne = scannerLigne.next();
		tab = ligne.split(";");
		
		for(int i = 0; i<tab.length; i++) {
			try {
				Integer.valueOf(tab[i]);
				Column<Integer> col = new Column<>(listeLabel.get(i));
				data.addColumn(col);
			} catch (Exception e) {
				try {
				Double.valueOf(tab[i]);
				Column<Double> col = new Column<>(listeLabel.get(i));
				data.addColumn(col);
				} catch (Exception e2) {
					Column<String> col = new Column<>(listeLabel.get(i));
					data.addColumn(col);
				}
			}
			
		}
		
		while(scannerLigne.hasNext()) {
			ligne = scannerLigne.next();
			tab = ligne.split(";");
			for(int i = 0; i<tab.length; i++) {
				
				
			}
			
		}
		
	}
}

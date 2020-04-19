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
	static ArrayList<Object[]> liste = new ArrayList<>();

	public static Object[][] parse(String csvFile){

	public static Object[][] parse(String csvFile){

		file = new File(csvFile);
		Object[][] tab;

		try {
			scannerLigne = new Scanner(file);
		} catch (Exception e) {
			System.err.println("Fichier non existant");
			return null;
		}

		scannerLigne = scannerLigne.useDelimiter("\n");
		String ligne = scannerLigne.next();
		liste.add(ligne.split(";"));
		while(scannerLigne.hasNext()) {
			ligne = scannerLigne.next();
			liste.add(ligne.split(";"));
		}

		tab = new Object[liste.size()][liste.get(0).length];

		for (int i = 0; i < liste.size(); i++) {
			for(int j = 0; j < liste.get(0).length; j++) {
				tab[i][j] = checkType(i,j);
			}
		}

		return tab;

	}


	private static Object checkType(int i, int j) {
		Object tmp;
		try {
			tmp = Integer.valueOf((String) liste.get(i)[j]);
		} catch (Exception e) {
			try {
				tmp = Double.valueOf((String) liste.get(i)[j]);
			} catch (Exception e2) {
				tmp = (String) liste.get(i)[j];
			}

		}
		return tmp;
	}
}

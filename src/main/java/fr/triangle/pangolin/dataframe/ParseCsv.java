package fr.triangle.pangolin.dataframe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseCsv {

	public static Object[][] parse(String csvFile) throws FileNotFoundException{
		List<String[]> liste = new ArrayList<>();
		Object[][] tab;
		File file = new File(csvFile);
		try (Scanner scannerLigne = new Scanner(file)){
			scannerLigne.useDelimiter("\n");
			String ligne = "";
			while(scannerLigne.hasNext()) {
				ligne = scannerLigne.next();
				liste.add(ligne.split(";"));
			}
			if(!ligne.isEmpty()) {
				tab = new Object[liste.size()][liste.get(0).length];
			}
			else {
				return null;
			}
			for (int i = 0; i < liste.size(); i++) {
				for(int j = 0; j < liste.get(0).length; j++) {
					tab[i][j] = checkType(liste.get(i)[j]);
				}
			}
			return tab;
		}catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}

	}

	private static Object checkType(String str) {
		Object tmp;
		try {
			tmp = Integer.valueOf(str);
		} catch (Exception e) {
			try {
				tmp = Double.valueOf(str);
			} catch (Exception e2) {
				tmp = str;
			}

		}
		return tmp;
	}
}

package by.fomkin.homework_appliance.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplianceReader {

	private final String sourcePath;

	public ApplianceReader(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public List<String> take() throws FileNotFoundException {
		File file = new File(sourcePath);
		Scanner scan = new Scanner(file);

		List<String> appliance = new ArrayList<>();
		while (scan.hasNextLine()) {
			appliance.add(scan.nextLine());
		}
		scan.close();
		return appliance;

	}

	public List<String> take(String groupName) throws FileNotFoundException {
		File file = new File(sourcePath);
		Scanner scan = new Scanner(file);
		List<String> appliance = new ArrayList<>();
		String s = "";
		while (scan.hasNextLine()) {
			s = scan.nextLine();
			if (s.contains(groupName)) {
				appliance.add(s);
			}

		}
		scan.close();
		return appliance;

	}

}

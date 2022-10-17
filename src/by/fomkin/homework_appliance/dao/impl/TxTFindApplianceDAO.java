package by.fomkin.homework_appliance.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.fomkin.homework_appliance.bean.Appliance;
import by.fomkin.homework_appliance.bean.Laptop;
import by.fomkin.homework_appliance.bean.Oven;
import by.fomkin.homework_appliance.bean.Refrigerator;
import by.fomkin.homework_appliance.bean.Speakers;
import by.fomkin.homework_appliance.bean.TabletPC;
import by.fomkin.homework_appliance.bean.VacuumCleaner;
import by.fomkin.homework_appliance.bean.criteria.Criteria;
import by.fomkin.homework_appliance.dao.ApplianceDataMatcher;
import by.fomkin.homework_appliance.dao.ApplianceReader;
import by.fomkin.homework_appliance.dao.DAOException;
import by.fomkin.homework_appliance.dao.FindApplianceDAO;

public class TxTFindApplianceDAO implements FindApplianceDAO {

	private final String separator = File.separator;

	private final String path = "src" + separator + "main" + separator + "resourse" + separator + "Appliance.txt";

	public List<Appliance> find(Criteria criteria) throws DAOException {
		ApplianceReader applianceReader = new ApplianceReader(path);

		List<String> dataFromSource = null;

		try {

			if (criteria.getGroupSearchName() != null) {
				dataFromSource = applianceReader.take(criteria.getGroupSearchName());
			} else {
				dataFromSource = applianceReader.take();
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}

		ApplianceDataMatcher matcher = new ApplianceDataMatcher(dataFromSource, criteria);
		List<String> dataAfterMatching = matcher.match();
		List<Appliance> appliances = appliancesFromStrings(dataAfterMatching);

		return appliances;
	}

	public List<Appliance> appliancesFromStrings(List<String> data) {
		List<Appliance> appliances = new ArrayList<>();
		for (String applianceString : data) {
			String[] stringData = applianceString.split(" :|,\\s+|=");
			String groupName = stringData[0];

			switch (groupName) {
			case "Laptop":
				appliances.add(new Laptop(Double.parseDouble(stringData[2]), stringData[4],
						Integer.parseInt(stringData[6]), Integer.parseInt(stringData[8]),
						Double.parseDouble(stringData[10]), Integer.parseInt(stringData[12])));
				break;
			case "Oven":
				Oven oven = new Oven(Integer.parseInt(stringData[2]), Integer.parseInt(stringData[4]),
						Integer.parseInt(stringData[6]), Integer.parseInt(stringData[8]),
						Double.parseDouble(stringData[10]), Double.parseDouble(stringData[12]));
				appliances.add(oven);

				break;
			case "Refrigerator":
				appliances.add(new Refrigerator(Integer.parseInt(stringData[2]), Integer.parseInt(stringData[4]),
						Integer.parseInt(stringData[6]), Integer.parseInt(stringData[8]),
						Integer.parseInt(stringData[10]), Integer.parseInt(stringData[12])));
				break;
			case "Speakers":
				appliances.add(new Speakers(Integer.parseInt(stringData[2]), Integer.parseInt(stringData[4]),
						stringData[6], Integer.parseInt(stringData[8])));
				break;
			case "TabletPC":
				appliances.add(new TabletPC(Integer.parseInt(stringData[2]), Integer.parseInt(stringData[4]),
						Integer.parseInt(stringData[6]), Integer.parseInt(stringData[8]), stringData[10]));
				break;
			case "VacuumCleaner":
				appliances.add(new VacuumCleaner(Integer.parseInt(stringData[2]), stringData[4], stringData[6],
						stringData[8], Integer.parseInt(stringData[10]), Integer.parseInt(stringData[12])));
				break;
			}
		}

		return appliances;
	}

}

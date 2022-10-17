package by.fomkin.homework_appliance.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import by.fomkin.homework_appliance.bean.criteria.Criteria;

public class ApplianceDataMatcher {

	private List<String> dataFromSource;
	private Criteria criteria;

	public ApplianceDataMatcher(List<String> dataFromSource, Criteria criteria) {
		this.dataFromSource = dataFromSource;
		this.criteria = criteria;
	}

	public List<String> match() {
		List<String> applianceDataResult = new ArrayList<>();
		List<String> searchPatterns = formFindPattern();

		for (String data : dataFromSource) {
			if (checkToPatterns(data, searchPatterns) == true) {
				applianceDataResult.add(data);
			}
		}

		return applianceDataResult;
	}

	private List<String> formFindPattern() {
		List<String> keyValue = new ArrayList<>();

		for (Map.Entry<String, Object> pair : criteria.getCriteria().entrySet()) {
			String line = pair.getKey() + "=" + pair.getValue();
			keyValue.add(line);
		}
		return keyValue;
	}

	private boolean checkToPatterns(String data, List<String> searchPatterns) {
		for (String pattern : searchPatterns) {
			if (!data.contains(pattern)) {
				return false;
			}
		}

		return true;
	}

}

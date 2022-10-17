package by.fomkin.homework_appliance.main;

import java.util.List;

import by.fomkin.homework_appliance.bean.Appliance;
import by.fomkin.homework_appliance.bean.criteria.Criteria;
import by.fomkin.homework_appliance.service.ApplianceService;
import by.fomkin.homework_appliance.service.ServiceException;
import by.fomkin.homework_appliance.service.ServiceFactory;

public class Main {

	public static void main(String[] args) throws MainException {

		List<Appliance> appliances = null;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteria = new Criteria("Oven");
		criteria.add("HEIGHT", 45);
		try {
			appliances = service.find(criteria);
		} catch (ServiceException e) {
			throw new MainException();
		}

		for (Appliance a : appliances) {
			System.out.println(a);
		}

	}

}

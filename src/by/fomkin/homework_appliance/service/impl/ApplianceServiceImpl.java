package by.fomkin.homework_appliance.service.impl;

import java.io.FileNotFoundException;
import java.util.List;

import by.fomkin.homework_appliance.bean.Appliance;
import by.fomkin.homework_appliance.bean.criteria.Criteria;
import by.fomkin.homework_appliance.dao.DAOException;
import by.fomkin.homework_appliance.dao.DAOFactory;
import by.fomkin.homework_appliance.dao.FindApplianceDAO;
import by.fomkin.homework_appliance.service.ApplianceService;
import by.fomkin.homework_appliance.service.ServiceException;
import by.fomkin.homework_appliance.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

	public List<Appliance> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		FindApplianceDAO applianceDAO = factory.getFindApplianceDAO();

		List<Appliance> appliances;

		try {
			appliances = applianceDAO.find(criteria);
		} catch (DAOException | FileNotFoundException e) {
			throw new ServiceException(e);
		}

		return appliances;
	}

}

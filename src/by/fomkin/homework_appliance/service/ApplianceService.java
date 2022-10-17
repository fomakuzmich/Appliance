package by.fomkin.homework_appliance.service;

import java.io.FileNotFoundException;
import java.util.List;

import by.fomkin.homework_appliance.bean.Appliance;
import by.fomkin.homework_appliance.bean.criteria.Criteria;

public interface ApplianceService {

	List<Appliance> find(Criteria criteria) throws ServiceException;

}

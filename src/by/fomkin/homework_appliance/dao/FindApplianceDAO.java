package by.fomkin.homework_appliance.dao;

import java.io.FileNotFoundException;
import java.util.List;

import by.fomkin.homework_appliance.bean.Appliance;
import by.fomkin.homework_appliance.bean.criteria.Criteria;

public interface FindApplianceDAO {

	List<Appliance> find(Criteria criteria) throws DAOException, FileNotFoundException;

}

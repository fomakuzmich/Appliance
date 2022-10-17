package by.fomkin.homework_appliance.dao;

import by.fomkin.homework_appliance.dao.impl.TxTFindApplianceDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final FindApplianceDAO findApplianceDAO = new TxTFindApplianceDAO();

	private DAOFactory() {
	}

	public FindApplianceDAO getFindApplianceDAO() {
		return findApplianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

}

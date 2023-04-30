package model;

import dao.AccountDAO;

public class RegistrationLogic {
	public boolean execute(Registration registration) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.registrationUser(registration);
		return result;
	}
}
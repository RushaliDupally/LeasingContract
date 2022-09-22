package com.allane.contract.validations;

import org.springframework.stereotype.Component;

@Component
public class GenericValidations {
	
	public boolean handleSpecialCharectersValidation(String str) {
		return str.toLowerCase().matches("[a-zA-ZäöüÄÖÜ]*$");
	}
	
	public boolean handleLengthValidation(String str) {
		return str.length() > Constants.STR_LENGTH;
	}
	
	public boolean handleNegativeValidationsForDouble(Double amount) {
		return amount <= 0.00;
	}
	
	public boolean handleNegativeValidationsForInteger(Integer amount) {
		return amount <= 0;
	}	
}

package com.sirma.itt.javacourse.refanreg;

public class IbanValidator {

	public String hideIban(String iban) {
		String newIban = iban.replaceAll("BG80 BNBG( \\d{4}){3}(?=( \\d{4}){1}<\\/iban>)", "****");
		return newIban;
	}
}

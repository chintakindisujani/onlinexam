package com.iwinner.store.helper;

public enum Role {
	ADMIN("ADMIN"), MANAGER("MANAGER"), HR("HR"), EMPLOYEE("EMPLOYEE"),DEVELPOER("DEV"),IT_SALES("IT_SALES"),TESTER("TESTER");

	private final String message;

	private Role(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}

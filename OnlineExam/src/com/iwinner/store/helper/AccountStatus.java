package com.iwinner.store.helper;

public enum AccountStatus {
	ACTIVE("Active"), LOCKED("Locked");

	private final String message;

	private AccountStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
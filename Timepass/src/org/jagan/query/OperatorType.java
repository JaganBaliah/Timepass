package org.jagan.query;

public enum OperatorType {
	
	AND ("AND"),
	OR ("OR");
	
	private final String name;
	
	OperatorType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

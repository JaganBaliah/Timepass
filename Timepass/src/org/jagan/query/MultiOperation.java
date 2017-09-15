package org.jagan.query;

import java.util.List;

public class MultiOperation {
	
	private OperatorType operatorType;
	private List<MultiOperation> operations;
	private boolean leaf;
	private boolean result = true;
	
	public MultiOperation(OperatorType operatorType, List<MultiOperation> operations) {
		super();
		this.operatorType = operatorType;
		this.operations = operations;
	}

	public MultiOperation(boolean leaf, boolean result) {
		this.leaf = leaf;
		this.result = result;
	}
	
	public OperatorType getOperatorType() {
		return operatorType;
	}

	public List<MultiOperation> getOperations() {
		return operations;
	}

	public boolean isLeaf() {
		return leaf;
	}
	
	public boolean getResult() {
		return result;
	}
}

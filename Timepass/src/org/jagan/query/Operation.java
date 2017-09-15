package org.jagan.query;

public class Operation {
	
	private OperatorType operatorType;
	private Operation leftOperation;
	private Operation rightOperation;
	private boolean leaf;
	private boolean result = true;
	
	public Operation(OperatorType operatorType, Operation leftOperation, Operation rightOperation) {
		super();
		this.operatorType = operatorType;
		this.leftOperation = leftOperation;
		this.rightOperation = rightOperation;
	}

	public Operation(boolean leaf, boolean result) {
		this.leaf = leaf;
		this.result = result;
	}
	
	public OperatorType getOperatorType() {
		return operatorType;
	}

	public Operation getLeftOperation() {
		return leftOperation;
	}

	public Operation getRightOperation() {
		return rightOperation;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
	public boolean getResult() {
		return result;
	}
}

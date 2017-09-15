package org.jagan.query;

public class OperationEvaluator {

	public static boolean getValue(Operation operation) {
		boolean rtnVal = true;
		rtnVal = evaluate(operation);
		return rtnVal;
	}
	
	private static boolean evaluate(Operation operation) {
		boolean rtnVal;
		
		if(operation.isLeaf()) {
			rtnVal = operation.getResult();
		} else {
			boolean leftEvaluate = evaluate(operation.getLeftOperation());
			boolean rightEvaluate = evaluate(operation.getRightOperation());
			if(operation.getOperatorType() == OperatorType.AND) {
				rtnVal = leftEvaluate && rightEvaluate;
			} else if(operation.getOperatorType() == OperatorType.OR) {
				rtnVal = leftEvaluate || rightEvaluate;
			} else {
				throw new RuntimeException("Invalid operation type");
			}
		}
		return rtnVal;
	}
}

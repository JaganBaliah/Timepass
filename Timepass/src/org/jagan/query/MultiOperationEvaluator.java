package org.jagan.query;

import java.util.List;

public class MultiOperationEvaluator {

	public static boolean getValue(MultiOperation operation) {
		boolean rtnVal = true;
		rtnVal = evaluate(operation);
		return rtnVal;
	}
	
	private static boolean evaluate(MultiOperation operation) {
		boolean rtnVal;
		
		if(operation.isLeaf()) {
			rtnVal = operation.getResult();
		} else {
			List<MultiOperation> multiOperations = operation.getOperations();
			if(operation.getOperatorType() == OperatorType.AND) {				
				for(MultiOperation multiOperation : multiOperations) {
					if(evaluate(multiOperation) == false) return false;					
				}
				return true;
			} else if(operation.getOperatorType() == OperatorType.OR) {
				for(MultiOperation multiOperation : multiOperations) {
					if(evaluate(multiOperation) == true) return true;					
				}
				return false;
			} else {
				throw new RuntimeException("Invalid operation type");
			}
		}
		return rtnVal;
	}
}

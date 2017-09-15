package org.jagan.query;

public class OperationTest {

	public static void main(String[] args) {
		Operation leftOperation1 = new Operation(true, false);
		Operation rightOperation1 = new Operation(true, false);
		Operation operation1 = new Operation(OperatorType.AND, leftOperation1, rightOperation1);

		Operation leftOperation2 = new Operation(true, true);
		Operation rightOperation2 = new Operation(true, true);
		Operation operation2 = new Operation(OperatorType.AND, leftOperation2, rightOperation2);

		Operation operation = new Operation(OperatorType.OR, operation1, operation2);

		System.out.println("Output : " + OperationEvaluator.getValue(operation));
		
	}
}

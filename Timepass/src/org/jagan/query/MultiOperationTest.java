package org.jagan.query;

import java.util.ArrayList;
import java.util.List;

public class MultiOperationTest {

	public static void main(String[] args) {
		MultiOperation operation11 = new MultiOperation(true, false);
		MultiOperation operation12 = new MultiOperation(true, true);
		List<MultiOperation> operations1 = new ArrayList<MultiOperation>();
		operations1.add(operation11);
		operations1.add(operation12);
		MultiOperation operation1 = new MultiOperation(OperatorType.AND, operations1);

		MultiOperation operation21 = new MultiOperation(true, false);
		MultiOperation operation22 = new MultiOperation(true, true);
		List<MultiOperation> operations2 = new ArrayList<MultiOperation>();
		operations2.add(operation21);
		operations2.add(operation22);
		MultiOperation operation2 = new MultiOperation(OperatorType.AND, operations2);

		List<MultiOperation> operations = new ArrayList<MultiOperation>();
		operations.add(operation1);
		operations.add(operation2);
		operations.add(new MultiOperation(true, false));
		MultiOperation operation = new MultiOperation(OperatorType.OR, operations);

		System.out.println("Output : " + MultiOperationEvaluator.getValue(operation));
		
	}
}

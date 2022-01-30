package bagsqueuesstack;

import java.util.LinkedList;
import java.util.List;

public class DijkstraAlgorithm {

    public static Double evaluateExpression(List<String> expression) {
        LinkedList<String> operators = new LinkedList<>();
        LinkedList<Double> values = new LinkedList<>();
        for (String element : expression) {
            if (element.equals("(")) continue;
            if (element.equals("+")) {
                operators.addFirst(element);
                continue;
            }
            if (element.equals("-")) {
                operators.addFirst(element);
                continue;
            }
            if (element.equals("*")) {
                operators.addFirst(element);
                continue;
            }
            if (element.equals("/")) {
                operators.addFirst(element);
                continue;
            }
            if (element.equals(")")) {
                String operator = operators.pollFirst();
                Double value = values.pollFirst();
                if (operator.equals("+")) value = values.pollFirst() + value;
                if (operator.equals("-")) value = values.pollFirst() - value;
                if (operator.equals("*")) value = values.pollFirst() * value;
                if (operator.equals("/")) value = values.pollFirst() / value;
                values.addFirst(value);
            } else {
                values.addFirst(Double.parseDouble(element));
            }
        }
        return values.getFirst();
    }
}

package bagsqueuesstack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraAlgorithmTest {

    @Test
    void shouldEvaluateExpression1() {
        String expression = "( ( 1 + 2 ) * 3 )";
        List<String> parsedExpression = Arrays.asList(expression.split("\\s+"));
        Double result = DijkstraAlgorithm.evaluateExpression(parsedExpression);

        assertEquals(9, result);
    }

    @Test
    void shouldEvaluateExpression2() {
        String expression = "( ( 10 - 2 ) / 4 )";
        List<String> parsedExpression = Arrays.asList(expression.split("\\s+"));
        Double result = DijkstraAlgorithm.evaluateExpression(parsedExpression);

        assertEquals(2, result);
    }

    @Test
    void shouldEvaluateExpression3() {
        String expression = "( ( 45 - 3 ) / ( 2 * 3 ) )";
        List<String> parsedExpression = Arrays.asList(expression.split("\\s+"));
        Double result = DijkstraAlgorithm.evaluateExpression(parsedExpression);

        assertEquals(7, result);
    }
}
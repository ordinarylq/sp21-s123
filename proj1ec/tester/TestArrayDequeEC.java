package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0:
                    // addFirst
                    int randomValue1 = StdRandom.uniform(0, 100);
                    studentArrayDeque.addFirst(randomValue1);
                    arrayDequeSolution.addFirst(randomValue1);
                    stringBuilder.append("addFirst(").append(randomValue1).append(")\n");
                    break;
                case 1:
                    // addLast
                    int randomValue2 = StdRandom.uniform(0, 100);
                    studentArrayDeque.addLast(randomValue2);
                    arrayDequeSolution.addLast(randomValue2);
                    stringBuilder.append("addLast(").append(randomValue2).append(")\n");
                    break;
                case 2:
                    // removeFirst
                    if (arrayDequeSolution.size() > 0 && studentArrayDeque.size() > 0) {
                        Integer expectedFirstValue = arrayDequeSolution.removeFirst();
                        Integer actualFirstValue = studentArrayDeque.removeFirst();
                        stringBuilder.append("removeFirst()\n");
                        assertEquals(stringBuilder.toString(), expectedFirstValue, actualFirstValue);
                    }
                    break;
                case 3:
                    // removeLast
                    if (arrayDequeSolution.size() > 0 && studentArrayDeque.size() > 0) {
                        Integer expectedLastValue = arrayDequeSolution.removeLast();
                        Integer actualLastValue = studentArrayDeque.removeLast();
                        stringBuilder.append("removeLast()\n");
                        assertEquals(stringBuilder.toString(), expectedLastValue, actualLastValue);
                    }
                    break;
                default:
                    /*ignore*/
            }
        }
    }
}

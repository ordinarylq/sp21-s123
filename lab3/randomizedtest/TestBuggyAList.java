package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> normalAList = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int cnt = 3;
        for (int i = 0; i < cnt; i++) {
            normalAList.addLast(i);
            buggyAList.addLast(i);
        }
        for (int i = 0; i < cnt; i++) {
            assertEquals(normalAList.removeLast(), buggyAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggyAListSize = buggyAList.size();
                assertEquals(size, buggyAListSize);
            } else if (operationNumber == 2) {
                assertEquals(L.size(), buggyAList.size());
                if (L.size() > 0) {
                    Integer lastItem = L.getLast();
                    Integer buggyAListLast = buggyAList.getLast();
                    assertEquals(lastItem, buggyAListLast);
                }
            } else if (operationNumber == 3) {
                assertEquals(L.size(), buggyAList.size());
                if(L.size() > 0) {
                    Integer lastItem = L.removeLast();
                    Integer buggyLastItem = buggyAList.removeLast();
                    assertEquals(lastItem, buggyLastItem);
                }
            }
        }
    }
}

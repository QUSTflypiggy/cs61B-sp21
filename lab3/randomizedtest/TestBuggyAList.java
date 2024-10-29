package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void test1() {
        AListNoResizing<Integer> al = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList<>();
        al.addLast(4);
        al.addLast(5);
        al.addLast(6);
        bl.addLast(4);
        bl.addLast(5);
        bl.addLast(6);
        assertEquals(bl.removeLast(), al.removeLast());
        assertEquals(bl.removeLast(), al.removeLast());
        assertEquals(bl.removeLast(), al.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B= new BuggyAList<>();

        int N = 5000;

        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeb= B.size();
                //System.out.println("size: " + size);
            }else if(operationNumber == 2) {
                if(L.size()==0)continue;
                int p=L.getLast();
                int q=B.getLast();
                //System.out.println("getLast(" + p + ")");
            }else if(operationNumber == 3) {
                if(L.size()==0)continue;
                L.removeLast();
                B.removeLast();
                //System.out.println("removeLast()");
            }
        }
    }
}

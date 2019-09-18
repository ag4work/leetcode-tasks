package easy_random.NumberOfRecentCalls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RecentCounter {

    int P = 3000;
    int c = 0;

    static boolean printLog = true;

    List<Integer> pings = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        while(true) {
            Integer e = q.peek();
            if (e == null) {
                break;
            }
            if (e < t - P) {
                q.remove();
            } else {
                break;
            }

        }
        q.add(t);
        return q.size();
    }

    public int ping1(int t) {
        pings.add(t);
        if (c == 0) {
            c = t;
            return 1;
        } else {

            return getCount(pings, P);
        }

    }

    private static int getCount(List<Integer> p, int threshold) {
        log(p);
        log("threshold: " + threshold);
        Integer last = p.get(p.size() - 1);
        int key = last - threshold;
        if (key <= 0) {
            log("Порог больше размера - возращаем весь размер.");
            return p.size();
        }
        log("key " + key);
        int i = Collections.binarySearch(p, key);
        log("i = " + i);
        int count;
        if (i >= 0) {
            count = p.size() - Math.abs(i);
        } else {
            count = p.size() - Math.abs(i) + 1;
        }

        log("count = " + count);
        return count;
    }

    public static void main(String[] args) {

//        List<Integer> p = new ArrayList<Integer>(){{add(1);}};
//        int count = getCount(p, 2);
//        asert(count , 1);
//        p.add(2);
//        p.add(3);
//        asert(getCount(p,2) , 2);
//        p.add(5);
//        asert(getCount(p,2),  1);
//
//        p.add(6);
//        asert(getCount(p,2),  2);
//
//        p = new ArrayList<Integer>(){{ add(1); add(4); add(5);}};
//        asert(getCount(p,3),  2);


        RecentCounter rc = new RecentCounter();
        asert(rc.ping(1),1);
        asert(rc.ping(100), 2);
        asert(rc.ping(3001), 3);
        asert(rc.ping(3002), 3);

    }
    public static void asert(int actual, int exp) {
        if (actual == exp) {
            log("Assert OK");
        } else {
            log("Expected: " + exp + " but was: " + actual);
        }
        log("\n");
    }

    static <T> void log(T s) {
        if (printLog) {
            System.out.println(s);
        }
    }    

}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

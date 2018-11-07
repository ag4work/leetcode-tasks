package fizzbuzz;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by agordeev on 20.02.2018.
 */
class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else res.add(String.valueOf(i));
        }
        return res;
    }
}

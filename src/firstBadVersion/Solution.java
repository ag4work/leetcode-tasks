package firstBadVersion;
/*278. First Bad Version
        You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

        You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

        Example:

        Given n = 5, and version = 4 is the first bad version.

        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true

        Then 4 is the first bad version.*/

public class Solution extends VersionControl {
    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(10));

    }

    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        long s = 1;
        long f = n;
        while (true) {
//            System.out.println(s + "  " + f);
            long sum = (long) f + s;
            long midIdx =  (int)Math.round(sum /2.0);

            boolean isPrevBadVersion = isBadVersion((int)midIdx - 1);

            boolean isCurBadVersion = isBadVersion((int)midIdx);
            if (isCurBadVersion && !isPrevBadVersion) {
                return (int)midIdx;
            }

            if (isCurBadVersion) {
                f = midIdx;
            } else {
                s = midIdx;
            }
        }
    }

}

class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 9;
    }
}
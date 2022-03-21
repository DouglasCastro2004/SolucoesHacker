import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int t = 0; t < tc; ++t) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            print(solve(n, k));
        }
    }
    private static int[] solve(int n, int k) {
        if (k > 0 && n % (2 * k) != 0) {
            return null;
        }
        int[] res = new int[n];
        int shift = k;
        for (int i = 1; i <= n; ++i) {
            res[i - 1] = i + shift;
            if (k > 0 && i % k == 0) {
                shift *= -1;
            }
        }
        return res;
    }
    private static void print(int[] a) {
        if (a == null) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < a.length; ++i) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}

package ict_practice_revisit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q19 {

    private static class Permutation {
        int n, r;
        int[] curr;
        List<List<Integer>> result;
        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            this.curr = new int[r];
            this.result = new ArrayList<>();
        }
        public void swap(List<Integer> orig, int i, int j) {
            int temp = orig.get(i);
            orig.set(i, orig.get(j));
            orig.set(j, temp);
        }
        public void generatePermutation(List<Integer> orig, int depth) {
            if (depth == r) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(orig.get(curr[i]));
                result.add(temp);
                return;
            }

            for (int i = depth; i < n; ++i) {
                swap(orig, depth, i);
                curr[depth] = depth;
                generatePermutation(orig, depth + 1);
                swap(orig, depth, i);
            }
        }
    }

    private static int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
    private static int n;
    private static int[] operands;
    private static List<List<Integer>> permutation;

    private static void goThrough() {
        for (List<Integer> coooo : permutation) {
            int temp = operands[0];
            for (int i = 0; i < n - 1; ++i) {
                // addition
                if (coooo.get(i) == 1) {
                    temp += operands[i + 1];
                }
                // subtraction
                else if (coooo.get(i) == 2) {
                    temp -= operands[i + 1];
                }
                // multiplication
                else if (coooo.get(i) == 3) {
                    temp *= operands[i + 1];
                }
                // division
                else {
                    if (operands[i + 1] == 0)
                        throw new RuntimeException("Divide by 0");

                    if (temp < 0 && operands[i + 1] > 0) {
                        temp *= -1;
                        temp /= operands[i + 1];
                        temp *= -1;
                    } else {
                        temp /= operands[i + 1];
                    }
                }
            }

            if (temp > mx)
                mx = temp;
            if (temp < mn)
                mn = temp;
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        operands = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i)
            operands[i] = Integer.parseInt(st.nextToken());

        List<Integer> operators = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; ++i) {
            int j = Integer.parseInt(st.nextToken());
            while (j-- > 0)
                operators.add(i);
        }
        Permutation p = new Permutation(n-1, n-1);
        p.generatePermutation(operators, 0);
        permutation = p.result;

        goThrough();

        bw.write(String.valueOf(mx) + "\n" + String.valueOf(mn) + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}

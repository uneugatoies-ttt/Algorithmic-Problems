package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ10610 {

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

        public void swap(List<Integer> arr, int i, int j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        public void generatePermutation(List<Integer> arr, int depth) {
            if (depth == r) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < r; ++i)
                    temp.add(arr.get(curr[i]));
                result.add(temp);
                return;
            }

            for (int i = depth; i < n; ++i) {
                swap(arr, i, depth);
                curr[depth] = depth;
                generatePermutation(arr, depth + 1);
                swap(arr, i, depth);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Integer[] arr = new Integer[s.length()];
        for (int i = 0; i < arr.length; ++i)
            arr[i] = s.charAt(i) - '0';
        Arrays.sort(arr, (i1, i2) -> Integer.compare(i2, i1));

        while ()
        s = "";



    }


    public static void main(String[] args) throws IOException {
        solve();
    }


}

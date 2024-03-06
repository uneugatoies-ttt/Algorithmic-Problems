package baekjoon;

import java.io.*;
import java.util.*;

// This can be computed by utilizing the divisibility rule; reference about it if you don't know what it is.
public class BJ10610 {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] entry = br.readLine().toCharArray();
        Arrays.sort(entry);
        int sum = 0;
        for (char c : entry)
            sum += c - '0';

        StringBuilder sb = new StringBuilder();
        if (entry[0] == '0' && sum % 3 == 0) {
            for (int i = entry.length - 1; i >= 0; --i)
                sb.append(entry[i]);
        } else {
            sb.append("-1");
        }
        sb.append('\n');
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}













// I didn't even finish this; there's no way this is the right solution.
/*
public class BJ10610 {

    private static class Permutation {
        int n, r;
        int[] curr;
        List<List<Integer>> result;
        public Permutation(int n) {
            this.n = n;
        }

        public void setR(int r) {
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
        Arrays.sort(arr);

        boolean flag = false;
        String result;
        String temp;
        int r = 1;
        Permutation t = new Permutation(arr.length);
        t.generatePermutation()
        while (!flag) {
            temp = "";
            for (int i = 0; i < arr.length; ++i)
                temp += String.valueOf(arr[arr.length - i - 1]);
            int tempint;
            if (temp.length() > 6) {
                tempint = Integer.parseInt(temp.substring(temp.length() - 6));
            } else {
                tempint = Integer.parseInt(temp);
            }

            if (tempint % 30 == 0) {
                result = temp;
                break;
            } else {
                r++;
                t.setR(r);
            }
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i)
            arr.add(s.charAt(i) - '0');
        Collections.sort(arr);

        boolean flag = false;
        String result;
        String temp;
        int r = 1;
        Permutation permutation = new Permutation(arr.size());

        while (!flag) {
            temp = "";
            for (int i = 0; i < arr.length; ++i)
                temp += String.valueOf(arr[arr.length - i - 1]);
            int tempint;
            if (temp.length() > 6) {
                tempint = Integer.parseInt(temp.substring(temp.length() - 6));
            } else {
                tempint = Integer.parseInt(temp);
            }

            if (tempint % 30 == 0) {
                result = temp;
                break;
            } else {
                r++;
                permutation.setR(r);
            }
        }
    }


    public static void main(String[] args) throws IOException {

    }


}
*/
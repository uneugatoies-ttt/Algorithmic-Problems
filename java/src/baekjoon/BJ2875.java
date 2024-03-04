package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A single team can be formed when there are 2 female students and 1 male student;
// this means that: if equilibrium is made in terms of the possible team numbers
// between females and males, then the decrement should take place;
// once with the 2 female students, and once with the 1 male student.
// This should be iterated until "k" reaches 0.
public class BJ2875 {

    private static int teamNumber(int n, int m) {
        int result = 0;
        int possibleFemale = n / 2;
        int possibleMale = m;
        if (possibleFemale == possibleMale)
            result = possibleFemale;
        else if (possibleFemale > possibleMale)
            result = possibleMale;
        else
            result = possibleFemale;
        return result;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k <= 0) {
            System.out.println(teamNumber(n, m));
            return;
        } else if (n <= 0 || m <= 0) {
            System.out.println(0);
            return;
        }

        if (n % 2 > 0) {
            k--;
            n--;
        }

        if (k <= 0) {
            System.out.println(teamNumber(n, m));
            return;
        } else if (n <= 0 || m <= 0) {
            System.out.println(0);
            return;
        }

        int possibleFemale = n / 2;
        int possibleMale = m;
        if (possibleFemale > possibleMale) {
            k -= (n - m*2);
            n -= (n - m*2);
        } else {
            k -= (m - n/2);
            m -= (m - n/2);
        }

        if (n <= 0 || m <= 0) {
            System.out.println(0);
            return;
        }

        boolean fturn = true, mturn;
        while (k > 0 && n > 0 && m > 0) {
            if (fturn) {
                n--;
                k--;
                if (n == 0 || k == 0) break;
                n--;
                k--;
                fturn = false;
                mturn = true;
            } else {
                m--;
                k--;
                mturn = false;
                fturn = true;
            }
        }

        if (k > 0) {
            System.out.println(0);
            return;
        }

        System.out.println(teamNumber(n, m));
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}





// failed attempt
/*
public class BJ2875 {

    private static int teamNumber(int n, int m) {
        int result = 0;
        int possibleFemale = n / 2;
        int possibleMale = m;
        if (possibleFemale == possibleMale)
            result = possibleFemale;
        else if (possibleFemale > possibleMale)
            result = possibleMale;
        else
            result = possibleFemale;
        return result;
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k <= 0) {
            System.out.println(teamNumber(n, m));
            return;
        }

        if (n % 2 > 0) {
            k--;
            n--;
        }

        if (k <= 0) {
            System.out.println(teamNumber(n, m));
            return;
        }

        int possibleFemale = n / 2;
        int possibleMale = m;
        if (possibleFemale > possibleMale) {
            k -= (n - m*2);
            n -= (n - m*2);
        } else {
            k -= (m - n/2);
            m -= (m - n/2);
        }

        boolean fturn = true, mturn;
        while (k > 0) {
            if (fturn) {
                n--;
                fturn = false;
                mturn = true;
            } else {
                m--;
                mturn = false;
                fturn = true;
            }
            k--;
        }

        System.out.println(teamNumber(n, m));
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
*/
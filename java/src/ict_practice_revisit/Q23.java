package ict_practice_revisit;

import java.io.*;
import java.util.*;

public class Q23 {

    private static class Student implements Comparable<Student> {
        String name;
        int k, e, m;
        public Student(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
        @Override
        public int compareTo(Student o) {
            if (this.k == o.k) {
                if (this.e == o.e) {
                    if (this.m == o.m)
                        return this.name.compareTo(o.name);
                    return Integer.compare(o.m, this.m);
                }
                return Integer.compare(this.e, o.e);
            }
            return Integer.compare(o.k, this.k);
        }
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            students.add(new Student(name, k, e, m));
        }

        Collections.sort(students);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i)
            sb.append(students.get(i).name + "\n");
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }

}
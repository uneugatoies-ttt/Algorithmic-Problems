package ict_practice.part3.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q20 {
	
	private static int n;
	// 0: empty, 1: teacher, 2: student, 3: obstruction
	private static int[][] hall;
	private static List<Pos> orig;
	private static List<Pos> teachers;
	private static boolean res;
	
	private static List<List<Pos>> combs;
	
	private static void search() {
		res = false;
		for (List<Pos> c : combs) {
			boolean thisres = true;
			for (Pos p : c)
				hall[p.y][p.x] = 3;
			
			for (Pos p : teachers) {
				int yy = p.y;
				int xx = p.x;
				
				// north
				yy--;
				while (yy > -1) {
					if (hall[yy][xx] == 2)
					{
						thisres = false;
						break;
					} else if (hall[yy][xx] == 3 || hall[yy][xx] == 1)
						break;
					yy--;
				}
				yy = p.y;
				
				// east
				xx++;
				while (thisres && xx < n) {
					if (hall[yy][xx] == 2)
					{
						thisres = false;
						break;
					} else if (hall[yy][xx] == 3 || hall[yy][xx] == 1)
						break;
					xx++;
				}
				xx = p.x;
				
				// south
				yy++;
				while (thisres && yy < n) {
					if (hall[yy][xx] == 2)
					{
						thisres = false;
						break;
					} else if (hall[yy][xx] == 3 || hall[yy][xx] == 1)
						break;
					yy++;
				}
				yy = p.y;
				
				// west
				xx--;
				while (thisres && xx > -1) {
					if (hall[yy][xx] == 2)
					{
						thisres = false;
						break;
					} else if (hall[yy][xx] == 3 || hall[yy][xx] == 1)
						break;
					xx--;
				}
				xx = p.x;
				
				
				if (!thisres)
					break;
			}
			
			if (thisres) {
				res = true;
				break;
			}
			
			for (Pos p : c)
				hall[p.y][p.x] = 0; 
		}
	}
	
	private static void solve() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(reader.readLine());
		hall = new int[n][n];
		orig = new ArrayList<>();
		teachers = new ArrayList<>();
		
		StringTokenizer token;
		String thisc;
		for (int i = 0; i < n; ++i) {
			token = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; ++j) {
				thisc = token.nextToken();
				if (thisc.equals("X")) {
					hall[i][j] = 0;
					orig.add(new Pos(i, j));
				} 
				else if (thisc.equals("T")) {
					hall[i][j] = 1;
					teachers.add(new Pos(i, j));
				}
				else if (thisc.equals("S"))
					hall[i][j] = 2;
			}
		}
		
		Comb c = new Comb(orig.size(), 3);
		c.gc(orig, 0, 0, 0);
		combs = c.result;
		
		search();
		
		if (res)
			writer.write("YES\n");
		else
			writer.write("NO\n");
		
		writer.flush();
		writer.close();
		reader.close();
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}
	
	private static class Comb {
		int n; int r; int[] curr; List<List<Pos>> result;
		public Comb(int n, int r) {
			this.n = n;
			this.r = r;
			this.curr = new int[r];
			this.result = new ArrayList<>();
		}
		
		public void gc(List<Pos> orig, int depth, int index, int target) {
			if (depth == r) {
				List<Pos> temp = new ArrayList<>();
				for (int i = 0; i < r; ++i)
					temp.add(orig.get(curr[i]));
				result.add(temp);
				return;
			}
			if (target == n) return;
			
			curr[index] = target;
			gc(orig, depth + 1, index + 1, target + 1);
			gc(orig, depth, index, target + 1);
		}
	}
	
	private static class Pos {
		int y; int x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}

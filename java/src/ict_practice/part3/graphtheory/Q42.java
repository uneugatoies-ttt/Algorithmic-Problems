package ict_practice.part3.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q42 {
	
	private static class Node {
		int ind;
		boolean docked;
		
		public Node(int ind) {
			this.ind = ind;
		}
	}
	
	private static int ggg, ppp;
	private static int[] planepossible;
	private static Node[] gates;
	
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ggg = Integer.parseInt(br.readLine());
		ppp = Integer.parseInt(br.readLine());
		gates = new Node[ggg];
		
		planepossible = new int[ppp];
		for (int i = 0; i < ppp; ++i)
			planepossible[i] = Integer.parseInt(br.readLine()) - 1;
		
		for (int i = 0; i < ggg; ++i)
			gates[i] = new Node(0);
		
		int cnt = 0;
		for (int i = 0; i < ppp; ++i) {
			int temp = planepossible[i];
			
			while (temp > -1 && gates[temp].docked)
				temp--;
			
			if (temp < 0)
				break;
			
			gates[temp].docked = true;
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		solve();
	}

}

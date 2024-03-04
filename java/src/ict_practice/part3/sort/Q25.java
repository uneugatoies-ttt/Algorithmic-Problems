package ict_practice.part3.sort;

import java.util.Arrays;

public class Q25 {
    public int[] solution(int N, int[] stages) {
    	double[] nume = new double[N];
    	double[] denom = new double[N];

    	int temp;
    	for (int i = 0; i < stages.length; ++i) {
    		temp = stages[i];
    		if (temp > N) {
    			for (int j = 0; j < N; ++j)
    				denom[j] += 1.0;
    			continue;
    		}
    		
    		nume[temp - 1] += 1.0;
    		for (int j = 0; j < temp; ++j)
    			denom[j] += 1.0;
    	}
    	
    	Stage[] res = new Stage[N];
    	for (int i = 0; i < N; ++i) {
    		if (denom[i] == 0)
    			res[i] = new Stage(i + 1, 0.0);
    		else
    			res[i] = new Stage(i + 1, nume[i] / denom[i]);
    	}
    	Arrays.sort(res, (s1, s2) -> Double.compare(s2.rate, s1.rate));
    	
    	int[] sortedRes = new int[N];
    	
    	for (int i = 0; i < N; ++i)
    		sortedRes[i] = res[i].ind;
    	
    	return sortedRes;
    }
    
    private static class Stage {
    	int ind;
    	double rate;
    	public Stage(int ind, double rate) {
    		this.ind = ind;
    		this.rate = rate;
    	}
    }
    
    public static void main(String[] args) {
		Q25 q = new Q25();
		//int n = 5;
		//int[] stages = {2,1,2,6,2,4,3,3};
		int n = 4;
		int[] stages = {4,4,4,4,4};
		
		System.out.println(Arrays.toString( q.solution(n, stages) ));
	}
    

}

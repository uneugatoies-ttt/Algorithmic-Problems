package algorithm.disjointset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
	A more simplified version of DSDS.
*/

public class DisjointSetUnion {

	// method for finding the connected 
	// component that the "i"th node belongs to
	private static int findParent(int i, int[] parent) {
		if (parent[i] != i)
			parent[i] = findParent(parent[i], parent);
		return parent[i];
	}
	
	// to merge the connected components of nodes a and b
	private static void union(int a, int b, int[] parent, int[] rank) {
		a = findParent(a, parent);
		b = findParent(b, parent);
		
		if (parent[a] == parent[b]) return;
		
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else {
			parent[a] = b;
			if (rank[a] == rank[b])
				rank[b]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(reader.readLine());
		int numberofnodes = Integer.parseInt(token.nextToken());
		int numberofedges = Integer.parseInt(token.nextToken());
		
		int[] parent = new int[100001];
		int[] rank = new int[100001];
		
		for (int i = 0; i < numberofnodes; ++i) {
			parent[i] = i;
			rank[i] = i;
		}
		
		int a, b;
		for (int i = 0; i < numberofedges; ++i) {
			token = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(token.nextToken());
			b = Integer.parseInt(token.nextToken());
			union(a, b, parent, rank);
		}
		
		
		
	}

}





//The original one:
/*
#include<stdio.h>
#define MOD 1000000007
int findParent(int i,int parent[])
//function to find the connected component that the ith node belongs to
{
if(parent[parent[i]]!=parent[i])
    parent[i]=findParent(parent[i],parent);
return parent[i];
}
void unionNodes(int a,int b,int parent[],int size[])
//to merge the connected components of nodes a and b
{
int parent_a=findParent(a,parent),parent_b=findParent(b,parent);
if(parent_a==parent_b)
    return;
if(size[parent_a]>=size[parent_b])//the larger connected component eats up the smaller one
{
     size[parent_a]+=size[parent_b];
     parent[parent_b]=parent_a;
}
else
{
     size[parent_b]+=size[parent_a];
     parent[parent_a]=parent_b;
}
return;
}

int main()
{

int N,M,i,a,b;
scanf(" %d %d",&amp;N,&amp;M);
int parent[100001]={0},size[100001]={0};
for(i=1;i<=N;i++)
{
    parent[i]=i;
    size[i]=1;
}

for(i=1;i<=M;i++)
{
    //scan each edge and merge the connected components of the two nodes
    scanf(" %d %d",&amp;a,&amp;b);
    unionNodes(a,b,parent,size);
}

for(i=1;i<=N;i++)
    printf("Node %d belongs to connected component %d\n",i,findParent(i,parent));
long long ways=1;
int nos=0;
for(i=1;i<=N;i++)
{
    if(findParent(i,parent)==i)//this condition is true only for disjoint connected components
    {
        printf("%d leader %d size\n",i,size[i]);
        nos++;
    }

}
printf("Total connected components : %d",nos);

return 0;
}
*/
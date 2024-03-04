package baekjoon;
import java.io.*;
import java.util.*;

public class BJ1167_2
{
    // 이중 배열로 만들어서 
	public static ArrayList<Node>[] tree;
	public static boolean visited[];
	public static int max=-1,loc;
	public static void dfs(int start,int dis){
        visited[start]=true;
        for(int i=0;i<tree[start].size();i++){
            Node tmp=tree[start].get(i);
            if(max<=dis){
                max=dis;
                loc=start;
            }
            if(!visited[tmp.x]){
                dfs(tmp.x,dis+tmp.weight);
            }
        }
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        int v=Integer.parseInt(br.readLine());
        visited=new boolean[v+1];
        tree=new ArrayList[v+1];
        for(int i=0;i<v+1;i++){
            tree[i]=new ArrayList<>();
        }
        
        int max_x=-1;
        for(int i=0;i<v;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());    
            int cnt=0;
            int second=0,dis=0;
            while(true){
                int tmp=Integer.parseInt(st.nextToken());
                if(tmp==-1) {break;}
                else {
                    if(cnt==0){
                        second=tmp;
                        cnt+=1;
                    } else {
                        dis=tmp;
                        tree[first].add(new Node(second,dis));
                        cnt=0;
                    }
                }
            }
        }

        dfs(1,0);
        int result1=max;
 
        max=0;
        visited=new boolean[v+1];
        dfs(loc,0);
        int result2=max;
      
        System.out.println(Math.max(result1,result2));
        
	}
	public static class Node {
	    int x;
	    int weight;
	    
	    public Node(int x,int weight){
	        this.x=x;
	        this.weight=weight;
	    }
	}
}



/*
static ArrayList<Node>[] list;
static boolean[] visited;
static int max = 0;
static int node;

public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    
    int n = scan.nextInt();
    list = new ArrayList[n + 1]; 
    for(int i = 1; i < n + 1; i++) {
        list[i] = new ArrayList<>();
    }
    
    for(int i = 0; i < n; i++) {
        int s = scan.nextInt();
        while(true) {
            int e = scan.nextInt();
            if(e == -1) break;
            int cost = scan.nextInt();
            list[s].add(new Node(e, cost));
        }
    }
    
    //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
    visited = new boolean[n + 1];
    dfs(1, 0);
    
    //node에서 부터 가장 먼 노트까지의 거리를 구한다.
    visited = new boolean[n + 1];
    dfs(node, 0);
    
    System.out.println(max);
}

public static void dfs(int x, int len) {
    if(len > max) {
        max = len;
        node = x;
    }
    visited[x] = true;
    
    for(int i = 0; i < list[x].size(); i++) {
        Node n = list[x].get(i);
        if(visited[n.e] == false) {
            dfs(n.e, n.cost + len);
            visited[n.e] = true;
        }
    }
    
}

public static class Node {
    int e;
    int cost;
    
    public Node(int e, int cost) {
        this.e = e;
        this.cost = cost;
    }
}
}
*/
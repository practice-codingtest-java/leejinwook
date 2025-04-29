import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int s,e;

    public Node(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Node o) {
        if(o.s - this.s == 0) return this.e - o.e;
        else return this.s - o.s;
    }
}
public class Main {
    static int n, m, v;
    static int[][] graph;
    static int[] ch;
    static ArrayList<Integer> answerDFS = new ArrayList<>();
    static ArrayList<Integer> answerBFS = new ArrayList<>();
    static ArrayList<Node> arr = new ArrayList<>();
    public void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        answerBFS.add(v);
        ch[v] = 1;
        queue.offer(v);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0;i<arr.size();i++){
                if(cur == arr.get(i).s){
                    int nx = arr.get(i).e;
                    if(ch[nx] == 0){
                        ch[nx] = 1;
                        queue.offer(nx);
                        answerBFS.add(nx);
                    }
                }
            }
        }
    }
    public void DFS(int d, int v){
        if(d == n) return;
        else{
            for (Node node : arr) {
                if(v == node.s && ch[node.e] == 0){
                    ch[node.e] = 1;
                    answerDFS.add(node.e);
                    DFS(d+1, node.e);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Node(s,e));
            arr.add(new Node(e,s));
            graph[s][e] = 1;
            graph[e][s] = 1;
        }
        Collections.sort(arr);
        answerDFS.add(v);
        ch[v] = 1;
        T.DFS(1, v);
        for (Integer answerDF : answerDFS) {
            bw.write(answerDF + " ");
        }
        bw.write("\n");
        Arrays.fill(ch, 0);
        T.BFS();
        for (Integer answerBF : answerBFS) {
            bw.write(answerBF + " ");
        }
        bw.flush();
        bw.close();
    }
}
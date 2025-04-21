import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int del;
    static int[] arr;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    public void DFS(int d){
        int cnt = 0;
        for(int i=0;i<tree.get(d).size();i++){
            if(!visited[tree.get(d).get(i)] && tree.get(d).get(i) != del){
                visited[tree.get(d).get(i)] = true;
                cnt++;
                DFS(tree.get(d).get(i));
            }
        }
        if(cnt == 0) answer++;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        arr = new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == -1){
                root = i;
            }
            else{
                tree.get(i).add(arr[i]);
                tree.get(arr[i]).add(i);
            }
        }
        del = Integer.parseInt(br.readLine());
        if (del == root) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }
        visited[root] = true;
        T.DFS(root);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
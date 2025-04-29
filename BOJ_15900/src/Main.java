import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, count = 0;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean[] visited;
    public void DFS(int n, int depth){
        boolean flag = true;
        for(int i=0;i<arrayList.get(n).size();i++){
            int nx = arrayList.get(n).get(i);
            if(!visited[nx]){
                flag = false;
                visited[nx] = true;
                DFS(nx, depth + 1);
            }
        }
        if(flag) count += depth;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            arrayList.get(to).add(from);
            arrayList.get(from).add(to);
        }
        visited[1] = true;
        T.DFS(1, 0);
        if(count % 2 == 0) bw.write("No");
        else bw.write("Yes");
        bw.flush();
        bw.close();
    }
}
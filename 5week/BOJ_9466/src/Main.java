import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited, done;
    static int answer;
    public void DFS(int n){
        if(visited[n]){
            done[n] = true;
            answer++;
        }else{
            visited[n] = true;
        }

        if(!done[arr[n]]){
            DFS(arr[n]);
        }
        visited[n] = false;
        done[n] = true;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            for(int j=1;j<=n;j++){
                arr[j] = Integer.parseInt(st.nextToken());

                if(j == arr[j]){
                    done[j] = true;
                    answer++;
                }
            }
            for(int j=1;j<=n;j++){
                if(!done[j]){
                    T.DFS(j);
                }
            }
            bw.write(String.valueOf(n - answer) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
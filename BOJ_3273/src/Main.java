import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int[] arr, int x){
        int answer = 0;
        Arrays.sort(arr);
        int s = 0, e = n - 1;
        while (s < e){
            int sum = arr[s] + arr[e];
            if(x == sum){
                s++;
                e--;
                answer++;
            } else if (x > sum) {
                s++;
            } else {
                e--;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int answer = T.solution(n, arr, x);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
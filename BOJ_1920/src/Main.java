import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public boolean[] solution(int n, int[] a, int cnt, int[] x){
        boolean[] answer = new boolean[cnt];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : a) {
            hashMap.put(i, 0);
        }
        for(int i=0;i<cnt;i++){
            if(hashMap.containsKey(x[i])) answer[i] = true;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = Integer.parseInt(br.readLine());
        int[] x = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<cnt;i++){
            x[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] answer = T.solution(n, a, cnt, x);
        for (boolean b : answer) {
            if(b) bw.write("1");
            else bw.write("0");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
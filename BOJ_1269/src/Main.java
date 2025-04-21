import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m, int[] a, int[] b){
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : a) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (int i : b) {
            if(hashMap.containsKey(i)) hashMap.remove(i);
            else hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        answer = hashMap.size();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        int answer = T.solution(n, m, a, b);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
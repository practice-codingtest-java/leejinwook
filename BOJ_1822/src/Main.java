import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public void solution(int n, int m, int[] a, int[] b){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : a) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (int i : b) {
            hashMap.remove(i);
        }
        arrayList.addAll(hashMap.keySet());
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
        T.solution(n, m, a, b);
        Collections.sort(arrayList);

        if(!arrayList.isEmpty()){
            bw.write(String.valueOf(arrayList.size()));
            bw.write("\n");
            for (Integer i : arrayList) {
                bw.write(String.valueOf(i ) + " ");
            }
        }
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}
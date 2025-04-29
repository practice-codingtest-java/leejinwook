import java.io.*;
import java.util.*;

class Word implements Comparable<Word>{
    String word;
    int cnt;
    Word (String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Word o) {
        if(this.cnt == o.cnt) {
            if(this.word.length() == o.word.length()) return this.word.compareTo(o.word);
            else return o.word.length() - this.word.length();
        }
        else return o.cnt - this.cnt;
    }
}
public class Main {
    public ArrayList<String> solution (int n, int m, String[] arr){
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<Word> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : arr) {
            if(s.length() < m) continue;
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for (String s : hashMap.keySet()) {
            arrayList.add(new Word(s, hashMap.get(s)));
        }
        Collections.sort(arrayList);
        for (Word word : arrayList) {
            answer.add(word.word);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        ArrayList<String> answer = T.solution(n, m, arr);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
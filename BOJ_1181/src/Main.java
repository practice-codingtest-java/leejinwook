import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Word implements Comparable<Word>{
    String word;
    Word(String word){
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        if(this.word.length() == o.word.length()) return this.word.compareTo(o.word);
        else return this.word.length() - o.word.length();
    }
}
public class Main {
    public ArrayList<String> solution(int n, ArrayList<String> arr){
        HashSet<String> hashSet = new HashSet<>(arr);
        ArrayList<Word> arrayList = new ArrayList<>();
        for (String s : hashSet) {
            arrayList.add(new Word(s));
        }
        ArrayList<String> answer = new ArrayList<>();
        Collections.sort(arrayList);
        for(int i=0;i<arrayList.size();i++){
            answer.add(arrayList.get(i).word);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(br.readLine());
        }
        ArrayList<String> answer = T.solution(n, arr);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}
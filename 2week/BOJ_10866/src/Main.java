import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, String[] arr, ArrayList<Integer> arrayList){
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int id = 0;
        for (String s : arr) {
            switch (s){
                case "push":
                    queue.offer(arrayList.get(id));
                    id++;
                    break;
                case "pop":
                    if(!queue.isEmpty()) answer.add(queue.poll());
                    else answer.add(-1);
                    break;
                case "size":
                    answer.add(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) answer.add(1);
                    else answer.add(0);
                    break;
                case "front":
                    if (!queue.isEmpty()) answer.add(queue.peek());
                    else answer.add(-1);
                    break;
                case "back":
                    if(! queue.isEmpty()) answer.add(((LinkedList<Integer>) queue).getLast());
                    else answer.add(-1);
                    break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            if(arr[i].equals("push")) arrayList.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer i : T.solution(n, arr, arrayList)) {
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[] direct;
    static int[][] arr;
    public void DFS(int depth){
        if(depth == 5){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    answer = Math.max(answer, arr[i][j]);
                }
            }
            return;
        }
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++){
            copy[i] = arr[i].clone();
        }
        for(int d=0;d<4;d++){
            move(d);
            DFS(depth+1);
            for(int i=0;i<n;i++){
                arr[i] = copy[i].clone();
            }
        }
    }
    public void move(int dir){
        switch (dir){
            // 위쪽
            case 0:
                for(int i=0;i<n;i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<n;j++){
                        if(arr[j][i] != 0){
                            if(block == arr[j][i]){
                                arr[index-1][i] = block*2;
                                block = 0;
                                arr[j][i] = 0;
                            }
                            else{
                                block = arr[j][i];
                                arr[j][i] = 0;
                                arr[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            // 왼쪽
            case 1:
                for(int i=0;i<n;i++){
                    int index = 0;
                    int block = 0;
                    for(int j=0;j<n;j++){
                        if(arr[i][j] != 0){
                            if(block == arr[i][j]){
                                arr[i][index-1] = block*2;
                                block = 0;
                                arr[i][j] = 0;
                            }
                            else{
                                block = arr[i][j];
                                arr[i][j] = 0;
                                arr[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            // 아래쪽
            case 2:
                for(int i=0;i<n;i++){
                    int index = n-1;
                    int block = 0;
                    for(int j=n-1;j>=0;j--){
                        if(arr[j][i] != 0){
                            if(block == arr[j][i]){
                                arr[index+1][i] = block*2;
                                block = 0;
                                arr[j][i] = 0;
                            }
                            else{
                                block = arr[j][i];
                                arr[j][i] = 0;
                                arr[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            // 오른쪽
            case 3:
                for(int i=0;i<n;i++){
                    int index = n-1;
                    int block = 0;
                    for(int j=n-1;j>=0;j--){
                        if(arr[i][j] != 0){
                            if(block == arr[i][j]){
                                arr[i][index+1] = block*2;
                                block = 0;
                                arr[i][j] = 0;
                            }
                            else{
                                block = arr[i][j];
                                arr[i][j] = 0;
                                arr[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        direct = new int[5];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.DFS(0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
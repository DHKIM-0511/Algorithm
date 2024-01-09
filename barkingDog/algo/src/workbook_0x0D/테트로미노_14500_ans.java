package workbook_0x0D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 테트로미노_14500_ans {
    static int n, m;
    static int[][] board = new int[502][502];
    static ArrayList<ArrayList<Pair>> tetro = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4 by 4에서 임의로 4칸을 선택해 해당 4칸이 붙어있는지 확인
        ArrayList<Integer> brute = new ArrayList<>(Collections.nCopies(16, 0));
        for (int i = 12; i < 16; i++) brute.set(i, 1);

        do {
            ArrayList<Pair> shape = new ArrayList<>();
            for (int i = 0; i < 16; i++)
                if (brute.get(i) == 1)
                    shape.add(new Pair(i / 4, i % 4));
            if (isConn(shape)) tetro.add(shape);
        } while (nextPermutation(brute));

        int ans = 0;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = 0; j <= m - 4; j++) {
                for (ArrayList<Pair> shape : tetro) {
                    int tot = 0;
                    for (Pair coor : shape)
                        tot += board[i + coor.x][j + coor.y];
                    ans = Math.max(tot, ans);
                }
            }
        }
        System.out.println(ans);
    }

    // a, b가 상하좌우로 인접한 칸인지 확인하는 함수
    static boolean isadj(Pair a, Pair b) {
        if (a.x == b.x) return Math.abs(a.y - b.y) == 1;
        if (a.y == b.y) return Math.abs(a.x - b.x) == 1;
        return false;
    }

    /*
    4개의 칸이 연결되어 있는지 확인하는 함수. BFS로 확인을 할 수도 있지만
    1. 모든 칸에 대해 상하좌우로 인접한 칸이 존재하고,
    2. 2개 이상의 칸과 인접한 칸이 1개라도 있으면
    4개의 칸이 연결되어 있음을 알 수 있다. 2번 조건을 빼먹으면
    1100
    0000
    1100
    0000
    과 같은 케이스를 놓치게 된다.
    */
    static boolean isConn(ArrayList<Pair> shape) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++)
                if (isadj(shape.get(i), shape.get(j))) cnt++;

            if (cnt == 0) return false;
            if (cnt >= 2) flag = true;
        }
        return flag;
    }
    static boolean nextPermutation(ArrayList<Integer> array) {
        int i = array.size() - 1;
        while (i > 0 && array.get(i - 1) >= array.get(i)) i--;
        if (i <= 0) return false;

        int j = array.size() - 1;
        while (array.get(j) <= array.get(i - 1)) j--;

        int temp = array.get(i - 1);
        array.set(i - 1, array.get(j));
        array.set(j, temp);

        j = array.size() - 1;
        while (i < j) {
            temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
            i++;
            j--;
        }
        return true;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

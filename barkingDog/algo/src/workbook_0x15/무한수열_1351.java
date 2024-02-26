package workbook_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열_1351 {
    static long n;
    static int p,q;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(fnc(n));
    }

    private static long fnc(long n) {
        if(n == 0) return 1;
        if(map.containsKey(n)) return map.get(n);

        map.put(n, fnc(n/p) + fnc(n/q));
        return map.get(n);
    }
}

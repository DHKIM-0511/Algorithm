package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 코드트리투어 {
    static int q,n,m,start;
    static List<List<Node>> adjList = new ArrayList<>();
    static PriorityQueue <Product> productQueue = new PriorityQueue<>(((o1, o2) -> {
        if (o1.pf == o2.pf) return Integer.compare(o1.id, o2.id);
        return Integer.compare(o2.pf, o1.pf); // MaxValue 근사치 일때 단순 뺄셈으로하면 오버플로우때문에 정렬이 제대로 동작 x
    }));
    static StringTokenizer st;
    static boolean[] prodStatus = new boolean[30001];
    static int[] costInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (q-- > 0){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            if(o == 100){
                //코드 트리 랜드 건설
                initGraph();
            }else if(o == 200){
                //여행 상품 생성
                addProduct();
            }else if(o == 300){
                //여행 상품 취소
                removeProduct();
            }else if(o == 400){
                //최적의 여행 상품 판매
                sb.append(sellProd()).append("\n");
            }else{
                //여행 상품의 출발지 변경
                start = Integer.parseInt(st.nextToken());
                updateStart();
            }
        }
        System.out.println(sb);
    }

    private static void updateStart() {
        costInfo = findCost();
        List<Product> products = new ArrayList<>();
        while (!productQueue.isEmpty()) products.add(productQueue.poll());

        for(Product p : products) {
            int pf = p.rev - costInfo[p.d];
            Product np = new Product(p.id, p.rev, p.d , pf);
            productQueue.offer(np);
        }
    }

    private static int sellProd() {
        //최적의 상품을 찾아 팔아야한다
        // 현재 시작지점에서 cost가 가장 작은 도시를 찾아야함
        while (!productQueue.isEmpty()){
            Product cur = productQueue.peek();
            if(cur.pf < 0){
                break;
            }
            productQueue.poll();

            if(prodStatus[cur.id]){
                return cur.id;
            }
        }
        return -1;
    }

    private static int[] findCost() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.e] < cur.w) continue;
            for(Node n : adjList.get(cur.e)){
                if(n.w + dist[cur.e] < dist[n.e]){
                    dist[n.e] = dist[cur.e] + n.w;
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }
        return dist;
    }

    private static void removeProduct() {
        int id = Integer.parseInt(st.nextToken());
        if(!prodStatus[id]) return;

        prodStatus[id] = false;
    }

    private static void addProduct() {
        int id = Integer.parseInt(st.nextToken());
        int rev = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        productQueue.offer(new Product(id, rev,d, rev - costInfo[d]));
        prodStatus[id] = true;
    }

    private static void initGraph() {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) adjList.add(new ArrayList<>());
        while (st.hasMoreTokens()){
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Node(v,w));
            adjList.get(v).add(new Node(u,w));
        }

        costInfo = findCost();

    }

    static class Node{
        int e,w;
        Node(int e,int w){
            this.e=e;
            this.w=w;
        }
    }
    static class Product{
        int id, rev, d, pf;
        Product(int id, int rev, int d, int pf){
            this.id = id;
            this.rev = rev;
            this.d = d;
            this.pf = pf;
        }

        @Override
        public String toString() {
            return "["+" ID: "+id+" 매출: "+rev+" 목적지: "+d+" 수익: "+pf+"]";
        }
    }
}

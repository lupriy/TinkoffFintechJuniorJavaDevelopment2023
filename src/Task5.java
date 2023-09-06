import java.util.*;

public class Task5 {
    static class Edge {
        int start, finish, height;

        public Edge(int start, int finish, int height) {
            this.start = start;
            this.finish = finish;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int s = scanner.nextInt();
            int f = scanner.nextInt();
            int h = scanner.nextInt();
            edges.add(new Edge(s, f, h));
        }

        edges.sort(Comparator.comparingInt(e -> e.height));

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int maxHeight = -1;
        for (Edge edge : edges) {
            int parentS = findParent(parent, edge.start);
            int parentF = findParent(parent, edge.finish);

            if (parentS != parentF) {
                maxHeight = edge.height;
                parent[parentF] = parentS;
            }
        }

        System.out.println(maxHeight);
    }

    static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}

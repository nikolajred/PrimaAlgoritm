public class PrimaAlgoritm {
    int INF = Integer.MAX_VALUE / 2;
    int vNum;
    int[][] graph;

    public int mstPrim() {
        boolean[] used = new boolean[vNum];
        int[] dist = new int[vNum];
        fill(dist, INF);
        dist[0] = 0;
        for (; ; ) {
            int v = -1;
            for (int nv = 0; nv < vNum; nv++)
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv]))
                    v = nv;
            if (v == -1) break;
            used[v] = true;
            for (int nv = 0; nv < vNum; nv++)
                if (!used[nv] && graph[v][nv] < INF)
                    dist[nv] = min(dist[nv], graph[v][nv]);
        }
        int ret = 0; // вес MST
        for (int v = 0; v < vNum; v++)
            ret += dist[v];
        return ret;
    }

}

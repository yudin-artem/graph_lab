package graph;

import collections.*;

public class Graph<V> {
    private List<V> vertices; // Список вершин
    private List<List<V>> adjacencyList; // Список смежности
    private List<List<Integer>> weightList; // Список весов


    public Graph() {
        vertices = new List<>();
        adjacencyList = new List<>();
        weightList = new List<>();
    }

    public void addVertex(V v) {
        if (vertices.find(v) != -1){
            throw new IllegalArgumentException("Vertex already exists");
        }
        vertices.pushback(v);
        adjacencyList.pushback(new List<>());
        weightList.pushback(new List<>());
    }

    public void addEdge(V from, V to, int weight) {
        int f = vertices.find(from); // индекс начальной вершины
        int t = vertices.find(to); // индекс конечной вершины

        if (f == -1){
            throw new IllegalArgumentException("Vertex " + from + " not found");
        }
        if (t == -1){
            throw new IllegalArgumentException("Vertex " + to + " not found");
        }

        adjacencyList.get(f).pushback(to);
        weightList.get(f).pushback(weight);
    }

    public void removeVertex(V v) throws IndexOutOfBoundsException {
        int d = vertices.find(v); // индекс мершины для удаления
        if (d == -1){
            throw new IllegalArgumentException("Vertex " + v + " not found");
        }

        List<V> adj = adjacencyList.get(d); // список смежности для удаляемой вершины
        for (int i = 0; i < adj.length(); i++){ // проверка всех зависимых вершин
            int rd = vertices.find(adj.get(i)); // индекс проверяемой вершины
            List<V> radj = adjacencyList.get(rd); // список смежности проверяемой вершины
            int res = radj.find(v); // индекс удаляемой вершины в списке смежности промеряемой вершины
            if (res != -1) {
                List<Integer> rweight = weightList.get(rd);
                radj.remove(res);
                rweight.remove(res);
            }
        }

        adjacencyList.remove(d);
        weightList.remove(d);
        vertices.remove(d);
    }

    public void removeEdge(V from, V to) {
        int f = vertices.find(from); // индекс начальной вершины
        int t = vertices.find(to); // индекс конечной вершины

        if (f == -1){
            throw new IllegalArgumentException("Vertex " + from + " not found");
        }
        if (t == -1){
            throw new IllegalArgumentException("Vertex " + to + " not found");
        }

        if (adjacencyList.get(f).find(to) == -1) {
            throw new IllegalArgumentException("Edge " + from + " - " + to + " not found");
        }

        int rind = adjacencyList.get(f).find(to); // индекс удаляемой конечной вершины в списке смежности начальной вершины
        adjacencyList.get(f).remove(rind);
        weightList.get(f).remove(rind);
    }

    public List<V> getAdjacents(V v) throws IndexOutOfBoundsException {
        int r = vertices.find(v);
        if (r == -1){
            throw new IllegalArgumentException("Vertex " + v + " not found");
        }

        return adjacencyList.get(r);
    }

    public void dfs(V start) {
        int startIndex = vertices.find(start);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Vertex " + start + " not found");
        }

        List<Boolean> visited = new List<>();
        for (int i = 0; i < vertices.length(); i++) {
            visited.pushback(false);
        }

        System.out.print("DFS: " + start);
        dfsRec(startIndex, visited);
    }

    // рекурсия для dfs
    private void dfsRec(int vertexIndex, List<Boolean> visited) {
        visited.insert(vertexIndex, true);

        List<V> neighbors = adjacencyList.get(vertexIndex);
        for (int i = 0; i < neighbors.length(); i++) {
            V next = neighbors.get(i);
            int nextIndex = vertices.find(next);
            if (nextIndex != -1 && !visited.get(nextIndex)) {
                System.out.print(" " + next);
                dfsRec(nextIndex, visited);
            }
        }
    }

    public void bfs(V start) {
        int startIndex = vertices.find(start);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Vertex " + start + " not found");
        }

        Queue<V> queue = new Queue<>();
        queue.enqueue(start);

        List<Boolean> visited = new List<>();
        for (int i = 0; i < vertices.length(); i++) {
            visited.pushback(false);
        }
        visited.insert(startIndex, true);

        System.out.print("BFS: " + start);

        while (!queue.isEmpty()) {
            V current = queue.dequeue();
            int currentIndex = vertices.find(current);
            List<V> neighbors = adjacencyList.get(currentIndex);

            for (int i = 0; i < neighbors.length(); i++) {
                V next = neighbors.get(i);
                int neighborIndex = vertices.find(next);
                if (neighborIndex != -1 && !visited.get(neighborIndex)) {
                    visited.insert(neighborIndex, true);
                    queue.enqueue(next);
                    System.out.print(" " + next);
                }
            }
        }
    }
}
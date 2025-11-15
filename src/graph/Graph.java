package graph;

import collections.*;

public class Graph<V> {
    private List<V> vertices;
    private List<List<V>> adjacencyList;
    private List<List<Integer>> weightList;
    private Queue<V> queue;


    public Graph() {
        vertices = new List<>();
        adjacencyList = new List<>();
        weightList = new List<>();
        queue = new Queue<>();
    }

    void addVertex(V v) {
        if (vertices.find(v) != -1){
            throw new IllegalArgumentException("Vertex already exists");
        }
        vertices.pushback(v);
        adjacencyList.pushback(new List<>());
    }

    void addEdge(V from, V to, int weight) {
        int f = vertices.find(from);
        int t = vertices.find(to);

        if (f == -1){
            throw new IllegalArgumentException("Vertex " + from + " not found");
        }
        if (t == -1){
            throw new IllegalArgumentException("Vertex " + to + " not found");
        }

        adjacencyList.get(f).pushback(to);
        weightList.get(f).pushback(weight);
    }

    void removeVertex(V v) throws IndexOutOfBoundsException {
        int d = vertices.find(v);
        if (d == -1){
            throw new IllegalArgumentException("Vertex " + v + " not found");
        }

        adjacencyList.remove(d);
        weightList.remove(d);
    }

    void removeEdge(V from, V to) {
        int f = vertices.find(from);
        int t = vertices.find(to);

        if (f == -1){
            throw new IllegalArgumentException("Vertex " + from + " not found");
        }
        if (t == -1){
            throw new IllegalArgumentException("Vertex " + to + " not found");
        }

        adjacencyList.get(f).remove(t);
        weightList.get(f).remove(t);
    }

    List<V> getAdjacents(V v) throws IndexOutOfBoundsException {
        int r = vertices.find(v);
        if (r == -1){
            throw new IllegalArgumentException("Vertex " + v + " not found");
        }

        return adjacencyList.get(r);
    }

    void dfs(V start) {

    }

    void bfs(V start) {

    }
}
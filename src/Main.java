import graph.Graph;
import collections.*;


public static void main() {
    Graph<String> graph = new Graph<>();
    try {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        try {
            graph.addVertex("A");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "A", 4);

        try {
            graph.addEdge("A", "E", 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        List<String> adjA = graph.getAdjacents("A");
        System.out.println("Смежные с A: " + adjA);
        List<String> adjB = graph.getAdjacents("B");
        System.out.println("Смежные с B: " + adjB);
        List<String> adjC = graph.getAdjacents("C");
        System.out.println("Смежные с C: " + adjC);
        List<String> adjD = graph.getAdjacents("D");
        System.out.println("Смежные с D: " + adjD);

        graph.dfs("A");
        graph.dfs("B");

        graph.bfs("C");
        graph.bfs("D");

        graph.removeEdge("A", "B");
        adjA = graph.getAdjacents("A");
        System.out.println("Смежные с A: " + adjA);
        try {
            graph.removeEdge("A", "B");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        graph.removeVertex("C");
        try {
            adjC = graph.getAdjacents("C");
            System.out.println("Смежные с C: " + adjC);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }



    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
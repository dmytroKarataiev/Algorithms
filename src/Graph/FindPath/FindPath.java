package Graph.FindPath;

import java.util.*;

/**
 * Class to perform BFS on a Graph
 */
class FindPath {

    public static void main(String[] args)  {

        GraphNode start = new GraphNode("start");
        GraphNode finish = new GraphNode("finish");
        System.out.println("Path exists: " + findPath(start, finish));
    }

    /**
     * Simple iterative solution of breadth-first graph search
     * @param start Starting node
     * @param end Node to which we are looking for a path
     * @param <T> type parameter
     * @return true if there is a path, false otherwise
     */
    public static <T> boolean findPath(GraphNode<T> start, GraphNode<T> end) {

        if (start == null || end == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        if (start.equals(end)) {
            return true;
        }

        // We need a FIFO queue and a Set which stores visited Nodes and can't have duplicates
        Queue<GraphNode<T>> queue = new LinkedList<>();
        Set<GraphNode<T>> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            GraphNode<T> current = queue.poll();

            if (current.equals(end)) {
                return true;
            }

            for (GraphNode<T> each : current.getChildren()) {

                if (visited.contains(each)) {
                    continue;
                }

                visited.add(each);
                queue.add(each);
            }
        }
        return false;
    }

    // Dummy implementation of GraphNode
    static class GraphNode<T> {
        String name;

        GraphNode(String name) {
            this.name = name;
        }

        List<GraphNode<T>> getChildren() {
            return null;
        }
    }


}
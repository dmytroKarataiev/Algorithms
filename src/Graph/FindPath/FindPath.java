/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016.  Dmytro Karataiev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
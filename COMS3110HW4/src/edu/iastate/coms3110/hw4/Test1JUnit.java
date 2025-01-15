package edu.iastate.coms3110.hw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

//No connections from a, this purely tests for null parent and inf. distances
public class Test1JUnit {

//	@Test
//	public void testDijkstras() {
//		Graph<String> g = new DirectedGraph<>();
//		String v1 = "a", v2 = "b", v3 = "c", v4 = "d", v5 = "e", v6 = "f";
//
//		Map<Tuple<String, String>, Double> weights = new HashMap<>();
//		Test1JUnit.addUndirectedEdge(g, v1, v2, 1.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v1, v4, 4.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v1, v5, 3.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v2, v4, 4.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v2, v5, 2.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v3, v5, 4.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v3, v6, 5.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v4, v5, 4.0, weights);
//		Test1JUnit.addUndirectedEdge(g, v5, v6, 7.0, weights);
//
//		var distsAndPreds = g.dijkstras(v1, weights);
//
//		Map<String, Double> expectedDistances = new HashMap<>();
//		expectedDistances.put("a", 0.0);
//		expectedDistances.put("b", 1.0);
//		expectedDistances.put("c", 7.0);
//		expectedDistances.put("d", 4.0);
//		expectedDistances.put("e", 3.0);
//		expectedDistances.put("f", 10.0);
//
//		Map<String, String> expectedPredecessors = new HashMap<>();
//		expectedPredecessors.put("a", null);
//		expectedPredecessors.put("b", "a");
//		expectedPredecessors.put("c", "e");
//		expectedPredecessors.put("d", "a");
//		expectedPredecessors.put("e", "a");
//		expectedPredecessors.put("f", "e");
//
//		assertEquals(expectedDistances, distsAndPreds.getFirst());
//		assertEquals(expectedPredecessors, distsAndPreds.getSecond());
//	}
//
//	@Test
//	public void testDijkstrasDisconnectedGraph1() {
//		Graph<String> g = new DirectedGraph<String>();
//		String v1 = "a", v2 = "b", v3 = "c";
//
//		Map<Tuple<String, String>, Double> weights = new HashMap<>();
//		addUndirectedEdge(g, v1, v2, 0.1, weights);
//		addUndirectedEdge(g, v1, v3, 0.3, weights);
//		addUndirectedEdge(g, v2, v3, 0.2, weights);
//
//		var distsAndPreds = g.dijkstras(v1, weights);
//
//		Map<String, Double> expectedDistances = new HashMap<>();
//		expectedDistances.put("a", 0.0);
//		expectedDistances.put("b", 0.1);
//		expectedDistances.put("c", 0.3);
//
//		Map<String, String> expectedPredecessors = new HashMap<>();
//		expectedPredecessors.put("a", null);
//		expectedPredecessors.put("b", "a");
//		expectedPredecessors.put("c", "a");
//
//		assertEquals(expectedDistances, distsAndPreds.getFirst());
//		assertEquals(expectedPredecessors, distsAndPreds.getSecond());
//	}
	
	@Test
    public void testDijkstrasDisconnectedGraph2() {
        Graph<String> g = new DirectedGraph<String>();
        String v1 = "1", v2 = "2", v3 = "3", v4 = "4", v5 = "5", v6 = "6", v7 = "7", v8 = "8", v9 = "9";

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);
        g.addVertex(v9);

        Map<Tuple<String, String>, Double> weights = new HashMap<>();

        g.addEdge(v1, v2);
        weights.put(Tuple.create(v1, v2), 5.0);
        g.addEdge(v1, v3);
        weights.put(Tuple.create(v1, v3), 2.0);
        g.addEdge(v2, v4);
        weights.put(Tuple.create(v2, v4), 3.0);
        g.addEdge(v2, v5);
        weights.put(Tuple.create(v2, v5), 7.0);
        g.addEdge(v3, v2);
        weights.put(Tuple.create(v3, v2), 2.0);
        g.addEdge(v3, v7);
        weights.put(Tuple.create(v3, v7), 9.0);
        g.addEdge(v4, v3);
        weights.put(Tuple.create(v4, v3), 3.0);
        g.addEdge(v4, v5);
        weights.put(Tuple.create(v4, v5), 2.0);
        g.addEdge(v4, v7);
        weights.put(Tuple.create(v4, v7), 6.0);
        g.addEdge(v5, v6);
        weights.put(Tuple.create(v5, v6), 8.0);
        g.addEdge(v5, v7);
        weights.put(Tuple.create(v5, v7), 5.0);
        g.addEdge(v5, v8);
        weights.put(Tuple.create(v5, v8), 7.0);
        g.addEdge(v6, v9);
        weights.put(Tuple.create(v6, v9), 4.0);
        g.addEdge(v7, v8);
        weights.put(Tuple.create(v7, v8), 2.0);
        g.addEdge(v8, v6);
        weights.put(Tuple.create(v8, v6), 3.0);


        var distsAndPreds = g.dijkstras(v1, weights);

        Map<String, Double> expectedDistances = new HashMap<>();
        expectedDistances.put("1", 0.0);
        expectedDistances.put("2", 4.0);
        expectedDistances.put("3", 2.0);
        expectedDistances.put("4", 7.0);
        expectedDistances.put("5", 9.0);
        expectedDistances.put("6", 16.0);
        expectedDistances.put("7", 11.0);
        expectedDistances.put("8", 13.0);
        expectedDistances.put("9", 20.0);

        Map<String, String> expectedPredecessors = new HashMap<>();
        expectedPredecessors.put("1", null);
        expectedPredecessors.put("2", "3");
        expectedPredecessors.put("3", "1");
        expectedPredecessors.put("4", "2");
        expectedPredecessors.put("5", "4");
        expectedPredecessors.put("6", "8");
        expectedPredecessors.put("7", "3");
        expectedPredecessors.put("8", "7");
        expectedPredecessors.put("9", "6");

        assertEquals(expectedDistances, distsAndPreds.getFirst());
        assertEquals(expectedPredecessors, distsAndPreds.getSecond());
    }

	public static void addUndirectedEdge(Graph<String> g, String v1, String v2, Double edgeWeight,
			Map<Tuple<String, String>, Double> weights) {
		g.addVertex(v1);
		g.addVertex(v2);
		g.addEdge(v1, v2); // Add edge v1 -> v2
		g.addEdge(v2, v1); // Add edge v2 -> v1
		weights.put(Tuple.create(v1, v2), edgeWeight);
		weights.put(Tuple.create(v2, v1), edgeWeight);
	}
}

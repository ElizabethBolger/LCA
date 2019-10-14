import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testForDirectedGraph(){
		DAG test = new DAG(10);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);

		assertEquals("", 1, test.indegree(4));
		assertEquals("", 2, test.outdegree(4));
		assertEquals("", 5, test.E());
		assertEquals("", 10, test.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test.adj(4).toString());
	}

	@Test
	public void testAddEdge(){
		DAG test4 = new DAG(5);
		test4.addEdge(3, 9);
		test4.addEdge(-2, -5);	
	}

	@Test
	public void testinDegree(){
		DAG test5 = new DAG(5);
		assertEquals("", -1, test5.indegree(-3));
	}

	@Test
	public void testOutDegree(){
		DAG test6 = new DAG(5);
		assertEquals("", -1, test6.outdegree(8));	
	}


	@Test(expected=Exception.class)
	public void exceptionTest(){
		//Can't make a directed graph with less than 0 vertices
		DAG test3 = new DAG(-5);
	}
	
	//Directed graph isnt necessary directed acyclic graph, so will need to ensure it is a DAG.
	@Test
	public void testsForCycle(){
		DAG cyclic = new DAG(20);
		cyclic.addEdge(0, 1);
		cyclic.addEdge(1, 2);
		cyclic.addEdge(2, 0);

		//Parameter is first vertex
		cyclic.findCycle(0);

		//Cycle from 0 - 1 - 2 - 0, should return true.
		assertTrue(cyclic.hasCycle());

		DAG acyclic = new DAG(20);
		acyclic.addEdge(0, 1);
		acyclic.addEdge(1, 3);
		acyclic.addEdge(2, 4);
		//Parameter is first vertex
		acyclic.findCycle(0);
		//No Cycle,return false
		assertFalse(acyclic.hasCycle());
	}

	
	//testing find LCA function
	@Test
	public void testLCA(){
		DAG lca = new DAG(10);

		//--------2---5----7--
		//---0--1-------6----8
		//--------3---4-------
		lca.addEdge(0, 1);
		lca.addEdge(1, 2);
		lca.addEdge(1, 3);
		lca.addEdge(2, 5);
		lca.addEdge(3, 4);
		lca.addEdge(4, 6);
		lca.addEdge(5, 6);

		assertEquals("Finding LCA for 4 and 5", 1, lca.findLCA(5, 4));
	}
	


}

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


}

package priv.weilinwu.GraphicModelDecodingProject;

import java.util.Random;

public class DecodingUtils {
	
	public double noiseGenerator(double variance) {
		Random random = new Random();
		return Math.sqrt(variance) * random.nextGaussian();
	}
	
	public double[] probabilityXBaxedOnZ(double receivedValueZ, double variance) {
		// probability of x equaling to 1 based on z
		double p1 = 1 / (Math.exp(2 * receivedValueZ / variance) + 1);
		// probability of x equaling to 0 based on z
		double p0 = 1 - p1;
		return new double[] {p0, p1};
	}
	
	public FactorGraphNode[] factorGraphGenerator(double variance) {
		// here Orthogonal List is used to represent the factor graph
		// construct 7 variable node and 3 function node
		FactorGraphNode[] nodes = new FactorGraphNode[10];
		for(int i = 0; i < 7; i++) {
			double receivedValueZ = noiseGenerator(variance) + 1;
			nodes[i] = new FactorGraphNode(probabilityXBaxedOnZ(receivedValueZ, variance));
		}
		for(int i = 7; i < 10; i++) {
			nodes[i] = new FactorGraphNode();
		}
		
		// create edges x0f7 means a directed edge with tail on nodes[0] and head on nodes[7]
		// where x denotes a variable node and f denotes a function node
		FactorGraphEdge[] edges = new FactorGraphEdge[24];
		edges[0] = new FactorGraphEdge(nodes[0], nodes[7]); //x0f7
		edges[1] = new FactorGraphEdge(nodes[7], nodes[0]); //f7x0
		edges[2] = new FactorGraphEdge(nodes[1], nodes[8]); //x1f8
		edges[3] = new FactorGraphEdge(nodes[8], nodes[1]); //f8x1
		edges[4] = new FactorGraphEdge(nodes[2], nodes[7]); //x2f7
		edges[5] = new FactorGraphEdge(nodes[7], nodes[2]); //f7x2
		edges[6] = new FactorGraphEdge(nodes[2], nodes[8]); //x2f8
		edges[7] = new FactorGraphEdge(nodes[8], nodes[2]); //f8x2
		edges[8] = new FactorGraphEdge(nodes[3], nodes[9]); //x3f9
		edges[9] = new FactorGraphEdge(nodes[9], nodes[3]); //f9x3
		edges[10] = new FactorGraphEdge(nodes[4], nodes[7]); //x4f7
		edges[11] = new FactorGraphEdge(nodes[7], nodes[4]); //f7x4
		edges[12] = new FactorGraphEdge(nodes[4], nodes[9]); //x4f9
		edges[13] = new FactorGraphEdge(nodes[9], nodes[4]); //f9x4
		edges[14] = new FactorGraphEdge(nodes[5], nodes[8]); //x5f8
		edges[15] = new FactorGraphEdge(nodes[8], nodes[5]); //f8x5
		edges[16] = new FactorGraphEdge(nodes[5], nodes[9]); //x5f9
		edges[17] = new FactorGraphEdge(nodes[9], nodes[5]); //f9x5
		edges[18] = new FactorGraphEdge(nodes[6], nodes[7]); //x6f7
		edges[19] = new FactorGraphEdge(nodes[7], nodes[6]); //f7x6
		edges[20] = new FactorGraphEdge(nodes[6], nodes[8]); //x6f8
		edges[21] = new FactorGraphEdge(nodes[8], nodes[6]); //f8x6
		edges[22] = new FactorGraphEdge(nodes[6], nodes[9]); //x6f9
		edges[23] = new FactorGraphEdge(nodes[9], nodes[6]); //f9x6
		
		// build connections between nodes and edges according to Orthogonal List
		
	}
	
	public void sumProductDecoding(FactorGraphNode[] factorGraph) {
		
	}
	
	public void maxProductDecoding(FactorGraphNode[] factorGraph) {
		
	}
}

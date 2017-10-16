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
		
		// create edges
		FactorGraphEdge x0f7 = new FactorGraphEdge(nodes[0], nodes[7]);
		FactorGraphEdge f0x0 = new FactorGraphEdge(nodes[7], nodes[0]);
		FactorGraphEdge x1f7 = new FactorGraphEdge(nodes[1], nodes[7]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		FactorGraphEdge  = new FactorGraphEdge(nodes[], nodes[]);
		
	}
	
	public void sumProductDecoding(FactorGraphNode[] factorGraph) {
		
	}
	
	public void maxProductDecoding(FactorGraphNode[] factorGraph) {
		
	}
}

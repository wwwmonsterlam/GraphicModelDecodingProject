package priv.weilinwu.GraphicModelDecodingProject;

public class FactorGraphNode {
	private FactorGraphEdge incomingEdge;
	private FactorGraphEdge outgoingEdge;
	private final boolean functionNodeFlag;
	private double[] distibutionBasedOnZ;  
	
	FactorGraphNode(double[] distribution) {
		functionNodeFlag = false;
		
		distibutionBasedOnZ = new double[2];
		distibutionBasedOnZ[0] = distribution[0];
		distibutionBasedOnZ[1] = distribution[1];	
		
		incomingEdge = null;
		outgoingEdge = null;
	}
	
	FactorGraphNode() {	
		functionNodeFlag = true;

		incomingEdge = null;
		outgoingEdge = null;
	}
	
	public void setIncomingEdge(FactorGraphEdge edge) {
		incomingEdge = edge;
	}
	
	public void setOutgoingEdge(FactorGraphEdge edge) {
		outgoingEdge = edge;
	}
	
	public FactorGraphEdge getIncomingEdge() {
		return incomingEdge;
	}
	
	public FactorGraphEdge getOutgoingEdge() {
		return outgoingEdge;
	}
	
	public boolean isFunctionNode() {
		return functionNodeFlag;
	}
	
	public void passMessagesWtihSumProductAlgo() {
		FactorGraphEdge targetEdge = this.outgoingEdge;
		while(targetEdge != null) {
			// multiply all the message carried on each incoming edge 
			// (except for the one corresponding to the target edge)
			
			targetEdge = targetEdge.getNextOutgoingEdge();
		}
		
	}
	
	public void passMessagesWtihMaxProductAlgo() {
		
	}
	
	public void messageSummary() {
		
	}
	
}

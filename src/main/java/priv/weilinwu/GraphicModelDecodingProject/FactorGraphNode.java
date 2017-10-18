package priv.weilinwu.GraphicModelDecodingProject;

public class FactorGraphNode {
	private FactorGraphEdge incomingEdge;
	private FactorGraphEdge outgoingEdge;
	private final boolean functionNodeFlag;
	private double[] distibutionBasedOnX;  
	
	FactorGraphNode(double[] distribution) {
		functionNodeFlag = false;
		
		distibutionBasedOnX = new double[2];
		distibutionBasedOnX[0] = distribution[0];
		distibutionBasedOnX[1] = distribution[1];	
		
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
		// the messages sent from a function node and a variable node follow different rules
		if(isFunctionNode()) {
			
		} else {
			// update message on each outgoing edge
			FactorGraphEdge targetEdge = this.outgoingEdge;
			while(targetEdge != null) {
				// multiply all the message carried on each incoming edge 
				// (except for the one corresponding to the target edge)
				double[] tempMessage = this.distibutionBasedOnX;
				FactorGraphEdge tempIncomingEdge = this.incomingEdge;
				while(tempIncomingEdge != null) {
					if(!targetEdge.getHeadNode().equals(tempIncomingEdge.getTailNode())) {
						tempMessage = OtherUtils.productOfTwoArraysWithSizeTwo(tempMessage, tempIncomingEdge.getMessage());
					}
					tempIncomingEdge = tempIncomingEdge.getNextIncomingEdge();
				}
				
				// update the message on the target edge
				targetEdge.setMessage(tempMessage);
				
				targetEdge = targetEdge.getNextOutgoingEdge();
			}
		}
	}
	
	public void passMessagesWtihMaxProductAlgo() {
		
	}
	
	public void messageSummary() {
		
	}
	
}

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
	
	public void passMessagesUsingSumProductAlgo() {
		// the messages sent from a function node and a variable node follow different rules
		if(isFunctionNode()) {
			// this is a function node
			// update message on each outgoing edge
			FactorGraphEdge targetEdge = this.outgoingEdge;
			while(targetEdge != null) {
				// there are 3 incoming edges 
				// (except for the one corresponding to the target edge)
				// get the messages on these three incoming edges				
				double[][] incomingMessages = new double[3][];
				FactorGraphEdge tempIncomingEdge = this.incomingEdge;
				int i = 0;
				while(tempIncomingEdge != null) {
					if(!targetEdge.getHeadNode().equals(tempIncomingEdge.getTailNode())) {
						incomingMessages[i++] = tempIncomingEdge.getMessage();
					}
					tempIncomingEdge = tempIncomingEdge.getNextIncomingEdge();
				}
				
				double[] tempMessage = new double[2];
				
				// when the variable in the head node of the target edge equals to 0
				// there are 8 combinations of the 4 edge messages, i.e., 0000, 0001, ..., 0111
				// the function of the this function node is specified in the report
				// if in the combination of the four variables there are even 1s, the function equals to 1
				double sum0 = 0.0;
				for(int j = 0; j < 8; j++) {
					sum0 += ((Integer.bitCount(j) + 1) % 2) * incomingMessages[0][j & 1] *
							incomingMessages[1][(j >>> 1) & 1] * incomingMessages[2][(j >>> 2) & 1];
				}
				tempMessage[0] = sum0;
				
				// when the variable in the head node of the target edge equals to 0
				// there are 8 combinations of the 4 edge messages, i.e., 1000, 1001, ..., 1111
				// the function of the this function node is specified in the report
				// if in the combination of the four variables there are even 1s, the function equals to 1
				double sum1 = 0.0;
				for(int j = 0; j < 8; j++) {
					sum1 += (Integer.bitCount(j) % 2) * incomingMessages[0][j & 1] *
							incomingMessages[1][(j >>> 1) & 1] * incomingMessages[2][(j >>> 2) & 1];
				}
				tempMessage[1] = sum1;
				
				// update the message on the target edge
				targetEdge.setMessage(tempMessage);
				
				targetEdge = targetEdge.getNextOutgoingEdge();
			}			
		} else {
			// this is a variable node
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
	
	public void passMessagesUsingMaxProductAlgo() {
		
	}
	
	public void messageSummary() {
		
	}
	
}

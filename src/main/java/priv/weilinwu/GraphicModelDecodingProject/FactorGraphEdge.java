package priv.weilinwu.GraphicModelDecodingProject;

public class FactorGraphEdge {
	
	private final FactorGraphNode tail;
	private final FactorGraphNode head;
	private FactorGraphEdge nextIncomingEdge;
	private FactorGraphEdge nextOutgoingEdge;
	private double[] message;
	
	FactorGraphEdge(FactorGraphNode t, FactorGraphNode h) {
		tail = t;
		head = h;
		
		// for sum-product algorithm, the initial message on each edge should be 1
		message = new double[2];
		message[0] = 1.0;
		message[1] = 1.0;
		
		nextIncomingEdge = null;
		nextOutgoingEdge = null;
	}
	
	public void setNextIncomingEdge (FactorGraphEdge next) {
		nextIncomingEdge = next;
	}
	
	public void setNextOutgoingEdge (FactorGraphEdge next) {
		nextOutgoingEdge = next;
	}
	
	public FactorGraphEdge getNextIncomingEdge() {
		return nextIncomingEdge;
	}
	
	public FactorGraphEdge getNextOutgoingEdge() {
		return nextOutgoingEdge;
	}
	
	public void setMessage(double[] m) {
		message[0] = m[0];
		message[1] = m[1];
	}
}

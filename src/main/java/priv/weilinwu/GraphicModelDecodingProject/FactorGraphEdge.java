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
		message[0] = 0.5;
		message[1] = 0.5;
		
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
	
	public FactorGraphNode getTailNode() {
		return tail;
	}
	
	public FactorGraphNode getHeadNode() {
		return head;
	}
	
	public double[] getMessage() {
		return new double[] {message[0], message[1]};
	}
	
	public void setMessage(double[] m) {
		if(m == null || m.length != 2) {
			System.out.println("Error!! Illegal message!");
			return;
		}
		
		// normalize the message so that it won't get too small nor too large
		double a = m[0] / (m[0] + m[1]);
		double b = 1 - a;
		message[0] = a;
		message[1] = b;
	}
}

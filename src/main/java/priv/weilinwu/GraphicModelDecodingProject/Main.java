package priv.weilinwu.GraphicModelDecodingProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import priv.weilinwu.GraphicModelDecodingProject.FactorGraphNode.DecodingAlgorithm;

public class Main {
	public static void main(String[] args) throws IOException {
		while(true) {
			int num = getNumOfDecodingFromUser();	
			DecodingUtils decodingUtils = new DecodingUtils();	
			double[] bitErrProbMpa = decodingUtils.decode(num, DecodingAlgorithm.MAX_PRODUCT);
			double[] bitErrProbSpa = decodingUtils.decode(num, DecodingAlgorithm.SUM_PRODUCT);
			experimentReport(bitErrProbMpa, bitErrProbSpa);
		}
	}
	
	public static int getNumOfDecodingFromUser() throws IOException {		
		while(true){
			System.out.println("How many times of decoding would you like me to conduct? ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String s = br.readLine();
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.println("Oops! Invalid input! Please do it again~");
			}
		}
	}
	
	public static void experimentReport(double[] bitErrProbMpa, double[] bitErrProbSpa) {
		System.out.println("########### Experiment Report ###########");
		double[] variances = {0.125, 0.25, 0.5, 1.0};
		for(int i = 0; i < 4; i++) {
			System.out.println("Noise variance: " + variances[i]);
			System.out.println("Bit error probability(MPA): " + bitErrProbMpa[i]);
			System.out.println("Bit error probability(SPA): " + bitErrProbSpa[i]);
			System.out.println("");
		}
	}
}

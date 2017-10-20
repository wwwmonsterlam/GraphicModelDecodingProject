package priv.weilinwu.GraphicModelDecodingProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import priv.weilinwu.GraphicModelDecodingProject.FactorGraphNode.DecodingAlgorithm;

public class Main {
	public static void main(String[] args) throws IOException {
		int num = getNumOfDecodingFromUser();	
		DecodingUtils decodingUtils = new DecodingUtils();	
		decodingUtils.decode(num, DecodingAlgorithm.MAX_PRODUCT);
		decodingUtils.decode(num, DecodingAlgorithm.SUM_PRODUCT);
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
}

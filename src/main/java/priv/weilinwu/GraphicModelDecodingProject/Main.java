package priv.weilinwu.GraphicModelDecodingProject;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.print("How many times of decoding would you like me to conduct? ");
		int num = 10000;
		int totalBit = num * 7;
		int errorBitCount = 0;
		DecodingUtils decodingUtils = new DecodingUtils();
		while(num-- > 0) {
			int[] result = decodingUtils.sumProductDecoding(decodingUtils.factorGraphGenerator(1.0), 20);
			for(int a : result) {
				if(a != 0) {
					errorBitCount++;
				}
			}
		}
		
		// Summary of this experiment
		System.out.println("********************** SUMMARY **********************");
		System.out.println("Total decoding coducted: " + totalBit / 7);
		System.out.println("Total bits transmitted: " + totalBit);
		System.out.println("Error bits count: " + errorBitCount);
	}
}

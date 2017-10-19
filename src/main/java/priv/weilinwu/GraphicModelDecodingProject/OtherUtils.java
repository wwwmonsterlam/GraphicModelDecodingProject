package priv.weilinwu.GraphicModelDecodingProject;

import java.util.Random;

public class OtherUtils {
	public static double[] productOfTwoArraysWithSizeTwo(double[] arrayA, double[] arrayB) {
		if (arrayA == null || arrayB == null || arrayA.length != 2 || arrayB.length != 2) {
			System.out.println("Error! The arrays are not legal!!");
			return null;
		}
		return new double[] {arrayA[0] * arrayB[0], arrayA[1] * arrayB[1]};
	}
	
	public static double noiseGenerator(double variance) {
		Random random = new Random();
		return Math.sqrt(variance) * random.nextGaussian();
	}
	
	public static double[] probabilityZiBaxedOnXi(double receivedValueZ, double variance) {
		// probability of z based on x equaling to 1
		double p1 = Math.exp(-(receivedValueZ + 1) * (receivedValueZ + 1) / 2 / variance) / Math.sqrt(Math.PI * 2 * variance);
		// probability of z based on x equaling to 0
		double p0 = Math.exp(-(receivedValueZ - 1) * (receivedValueZ - 1) / 2 / variance) / Math.sqrt(Math.PI * 2 * variance);;
		return new double[] {p0 / (p0 + p1), p1 / (p0 + p1)};
	}
	
	public static boolean isArraysEqual(int[] a, int[] b) {
		if(a == null || b == null) {
			System.out.println("Error! Empty array(s)!");
			return false;
		}
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true;
	}
}

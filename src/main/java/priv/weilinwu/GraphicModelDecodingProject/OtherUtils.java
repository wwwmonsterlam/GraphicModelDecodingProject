package priv.weilinwu.GraphicModelDecodingProject;

public class OtherUtils {
	public static double[] productOfTwoArraysWithSizeTwo(double[] arrayA, double[] arrayB) {
		if (arrayA == null || arrayB == null || arrayA.length != 2 || arrayB.length != 2) {
			System.out.println("Error! The arrays are not legal!!");
			return null;
		}
		return new double[] {arrayA[0] * arrayB[0], arrayA[1] * arrayB[1]};
	}
}

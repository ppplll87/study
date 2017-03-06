package study;

import utils.MathUtil;

public class FunctionTest {

	public static void main(String[] args) {
		
		int n = 10;
		int r = 2;
		
		System.out.println("n! ====> " + MathUtil.getFactorial(n));
		System.out.println("nPr ====> " + MathUtil.getPermutation(n, r));
		System.out.println("nCr ====> " + MathUtil.getCombination(n, r));
	}

}

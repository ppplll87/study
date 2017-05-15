package test;

import org.junit.Test;

import utils.MathUtil;

public class CommonTest {

	@Test
	public void test() {
		System.out.println(MathUtil.getPermutation(10, 2));
		System.out.println(MathUtil.getCombination(10, 2));
	}

}

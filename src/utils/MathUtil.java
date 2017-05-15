package utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class MathUtil {
	
	/**
	 * 약수를 구한다
	 * @param number
	 * @return
	 */
	public static ArrayList<Integer> getAliquot(final int number) {
		
		ArrayList<Integer> aliquotList = new ArrayList<>();
		
		if(number == 0) {
			throw new IllegalArgumentException("input 0");
		} else {
			// 1은 약수가 아님, 2부터 시작
			int i = 1;
			while( i <= number) {
				if((number % i) == 0) {
					aliquotList.add(i);
				}
				i++;
			}
		}
		return aliquotList;
	}
	
	/**
	 * 소수 인지 아닌지 판단
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumber(final int number) {
		
		ArrayList<Integer> aliquotList = getAliquot(number);
		
		if(aliquotList != null && aliquotList.size() == 2) {
			
			if(aliquotList.get(0) == 1 && aliquotList.get(1) == number) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 범위 안의 모든소수를 구한다
	 * @param number
	 * @return
	 */
	public static ArrayList<Integer> getPrimeNumber(final int minNumber, final int maxNumber) {
		
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
		
		int targetMin, targetMax;
		targetMin = minNumber == 0 || minNumber == 1 ? 2 : minNumber;
		targetMax = maxNumber == 0 || maxNumber == 1 ? 2 : maxNumber;
		if(targetMin > targetMax) {
			int tempNum = targetMax;
			targetMax = targetMin;
			targetMin = tempNum;
		}
		for(int i = minNumber; i <= maxNumber; i++) {
			if(isPrimeNumber(i)) {
				primeNumberList.add(i);
			}
		}
		return primeNumberList;
	}
	
	/**
	 * 조합을 구한다 (= nCr, nPr/r!)
	 * @param n
	 * @param r
	 * @return
	 */
	public static BigInteger getCombination(final int n, final int r) {
		
		if(n <= 0 || (n - r) < 0) {
			return BigInteger.valueOf(-1);
		} else if(r <= 0) {
			return BigInteger.valueOf(1);
		} else {
			return getPermutation(n, r).divide(getFactorial(r));
		}
	}
	
	/**
	 * 순열을 구한다 (= nPr, n!/(n-r)!)
	 * @param n 전체 원소 수
	 * @param i 선택 수
	 * @return
	 */
	public static BigInteger getPermutation(final int n, final int r) {
		
		if(n <= 0 || (n - r) < 0) {
			return BigInteger.valueOf(-1);
		} else if(r <= 0) {
			return BigInteger.valueOf(1);
		} else {
			return getFactorial(n).divide(getFactorial(n-r));
		}
	}
	
	/**
	 * 계승을 구한다 (= Factorial, 5!)
	 * @param number
	 * @return
	 */
	public static BigInteger getFactorial(final int number) {
		
		if(number <= 0 ) {
			return BigInteger.valueOf(-1);
		} else {
			
			BigInteger returnValue = BigInteger.valueOf(1);
			
			for(int i = number; i >= 1; i--) {
				returnValue = returnValue.multiply(BigInteger.valueOf(Long.valueOf(i)));
			}
			
			return returnValue;
		}
	}
}

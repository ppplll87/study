package utils;

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
}

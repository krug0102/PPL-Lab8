import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.lang.StringBuilder;

public class Lambdas implements Function {

	public static void main(String [] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		for (int i = 0; i < 10; ++i){
			numbers.add(i);
			strings.add(new String(Integer.toBinaryString(i)));
		}

		// passing an anonymous function to countElements:
		int countEvens = countElements(numbers, (n) -> (n % 2 == 0));
		System.out.println(countEvens);
		int countOdds = countElements(numbers, (n) -> (n % 2 != 0));
		System.out.println(countOdds);
		int countShortStrings = countElements(strings, (s) -> (s.length() < 4));
		System.out.println(countShortStrings);
		Predicate<String> notSmall = (s) -> (s.length() >= 2);
		Predicate<String> notLarge = (s) -> (s.length() <= 4);
		int countMediumStrings = countElements(strings, notSmall.and(notLarge));
		System.out.println(countMediumStrings);
		map(strings, stringRev(T));


	}



	public static <T> int countElements(ArrayList<T> theList, Predicate<T> cond) {
		int count = 0;
		for (T element : theList) {
			if (cond.test(element)) {
				count++;
			}
		}
		return count;
	}

	public static ArrayList<String> map(ArrayList<String> Strings, Function Func){
		ArrayList<String> result = new ArrayList<>(Strings.size());
		for (int i = 0; i < Strings.size(); i++) {
			result.add((String) Func.apply(Strings.get(i)));
		}
		return result;
	}

	public static String stringRev(String reversible){
		StringBuilder StringRunner = new StringBuilder(reversible);
		return StringRunner.reverse().toString();
	}

	public Object apply(Object o) {
		return null;
	}


	/**
	 * Problem 2: Lambdas
	 * Write a method that takes an array list of type T, returns an array list of type R,
	 * and uses the function to populate the new array list
	 */

}

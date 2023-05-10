import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.lang.StringBuilder;
import java.util.function.ToIntFunction;
import java.util.function.IntPredicate;


public class Lambdas {

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

		System.out.println("Problem 2: Lambdas");
		System.out.println(strings);
		ArrayList<String> reversed = ourMap(strings, reverseStrings);
		System.out.println(reversed);

		ArrayList<String> letters = new ArrayList<>();

		letters.add("Nik Bailey");
		letters.add("Blake Johnson");
		letters.add("Zeke Krug");
		letters.add("Max Quintavalle");
		letters.add("Nick Gilbertson");

		Function reverseAndUpper = reverseStrings.andThen(String::toUpperCase);

		System.out.println(letters);
		ArrayList<String> reversedAndUpper = ourMap(letters, reverseAndUpper);
		System.out.println(reversedAndUpper);

		ArrayList<Integer> lengths = new ArrayList<>();
		for(int i = 0; i < letters.size(); i++) {
			Integer length = getLengths.apply(letters.get(i));
			lengths.add(length);
		}
		System.out.println(lengths);

		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Lion", 166));
		animals.add(new Animal("Nik Bailey", 190));

		ArrayList<String> names = new ArrayList<>();
		for(int i = 0; i < animals.size(); i++) {
			String name = getName.apply(animals.get(i));
			names.add(name);
		}
		System.out.println(names);

		System.out.println("Problem 3: Lambdas");
		ArrayList<String> oddStrings = new ArrayList<>();
		for(int i = 0; i < letters.size(); i++) {
			int size = oddLength.applyAsInt(letters.get(i));
			if(!(size % 2 == 0)) {
				oddStrings.add(letters.get(i));
			}
		}
		System.out.println(oddStrings);

		ArrayList<String> stringsWithManyAs = new ArrayList<>();
		for(int i = 0; i < letters.size(); i++) {
			int aCount = twoOrMoreAs.applyAsInt(letters.get(i));
			if(aCount >= 2) {
				stringsWithManyAs.add(letters.get(i));
			}
		}
		System.out.println(stringsWithManyAs);

		ArrayList<String> stringsWithLittleAs = new ArrayList<>();
		for(int i = 0; i < letters.size(); i++) {
			int aCount = lessThanTwoAs.applyAsInt(letters.get(i));
			if(aCount <= 2) {
				stringsWithLittleAs.add(letters.get(i));
			}
		}
		System.out.println(stringsWithLittleAs);

		ArrayList<Animal> animalsWeighLess = new ArrayList<>();
		for(int i = 0; i < animals.size(); i++) {
			int weight = lessThan100.applyAsInt(animals.get(i));
			if(weight > 100) {
				animalsWeighLess.add(animals.get(i));
			}
		}
		System.out.println(animalsWeighLess);


		System.out.println("Problem 4: Reflection");


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


	/**
	 * Problem 2: Lambdas
	 * Write a method that takes an array list of type T, returns an array list of type R,
	 * and uses the function to populate the new array list
	 */
	public static ArrayList<String> ourMap(ArrayList<String> strings, Function fn) {
		ArrayList<String> result = new ArrayList<>();
		for(int i = 0; i < strings.size(); i++) {
			String s = (String) fn.apply(strings.get(i));
			result.add(s);
		}
		return result;
	}

	static Function<String, String> reverseStrings = s -> {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	};

	static Function<String, Integer> getLengths = s -> s.length();

	static Function<Animal, String> getName = s -> s.getName();

	/**
	 * Problem 3: Lambdas
	 * Write another method that takes an array list of type T, a function
	 * from T to intLinks to an external site., and a predicate on integersLinks
	 * to an external site., and returns an array list of the same type T. Use this method to:
	 */
	static ToIntFunction<String> oddLength = s -> s.length();

	static ToIntFunction<String> twoOrMoreAs = s -> {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a'){
				count++;
			}
		}
		return count;
	};

	static ToIntFunction<String> lessThanTwoAs = s -> {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a'){
				count++;
			}
		}
		return count;
	};

	static ToIntFunction<Animal> lessThan100 = s -> (int) s.getWeight();
} // end Lambdas

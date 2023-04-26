import java.util.ArrayList;

public class Examples {

	// Static: one per class; non-static: one per instance (needs an instance)
	public static void main(String[] args) throws MinMaxNotInitializedException{

		// Some generic (parametric) classes require their elements
		// to be Comparable.

		System.out.println("Testing MinMax on Integers");
		MinMax<Integer> minMaxInt = new MinMax<>();
		minMaxInt.add(2);
		minMaxInt.add(4);
		minMaxInt.add(3);
		System.out.println(minMaxInt.getMin());
		System.out.println(minMaxInt.getMax());
		System.out.println(minMaxInt.inRange(3));
		System.out.println(minMaxInt.inRange(8));

		System.out.println("Testing MinMax on Strings");
		MinMax<String> minMaxStr = new MinMax<>();
		minMaxStr.add("22");
		minMaxStr.add("4");
		minMaxStr.add("3");
		System.out.println(minMaxStr.getMin());
		System.out.println(minMaxStr.getMax());
		System.out.println(minMaxStr.inRange("23"));
		System.out.println(minMaxStr.inRange("4"));
		System.out.println(minMaxStr.inRange("A"));
	}

	public static int sum(int x, int y) {
		// What happens if we change x or y in this method?
		int s = x + y;
		x++;
		return s;
	}

	// must be static (used in static main).
	// Generally making classes and methods static may save memory.
	// If it doesn't need to be attached to an instance, make it static
	private static class A {
		protected int a;

		public A(int a) {
			this.a = a;
		}

		public A sum(A other) {
			// What happens if we change other in this method?
			int s = this.a + other.a;
			//other.a = 7;
			return new A(s);
		}

		public String toString() {
			return "A: a = " + a;
		}
	}

	private static class B extends A {
		private int b;

		public B(int a, int b) {
			super(a);
			this.b = b;
		}

		public B product(B other) {
			return new B(this.a, this.b * other.b);
		}

		public String toString() {
			return "B: a = " + a + " b = " + b;
		}
	}

}

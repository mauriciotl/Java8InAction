package lambdasinaction.chap2.bookExample;

import java.util.*;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(
				new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);


		/**
		 * With predicates:
		 */

		//Looks for green apple: AppleColorPredicate
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// Looks for bigger than 150
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println(heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);


		/**
		 * THE FOLLOWING ONE IS VERY COOL,  we are passing the predicate interface and
		 * creating the implementation in the same line:
		 * 1. We are creating an instance of the interface and implementing its
		 * 		abstract method, right there.
		 *
		 * 	So an appropriate name for the list variable should be aligned with the
		 * 	filter or implementation that we are applying, in order that everything makes sense;
		 * 	both the name and filter implementation.
		 */
		List<Apple> redApples2 = filter(inventory, new ApplePredicate()
			{
				public boolean test(Apple a)
					{
						return a.getColor().equals("red");
					} //Ends predicate method implementation.
			} //Ends the ApplePredicate class.
		);//Ends passing parameters to the filter method.

		System.out.println(redApples2);


	}//Ends main method.


	//The following are standard Java 7 methods.


	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}



	/**
	 * The third attempt:
	 *
	 * 2.2. Behavior parameterization
	 *
	 * The third attempt is about using a Predicate, up to now this is very similar to
	 * the Strategy pattern, except that a predicate is the following:
	 *
	 * We call this a predicate (that is, a function that returns a boolean).
	 *
	 *  VERY IMPORTANT. Of course this is all possible, meaning passing a method as a parameter of a method per se (itself),
	 *  thanks to java 8, that now allows that.
	 */


	/**
	 * The following is the golden method, the one that will be using the predicate interface,
	 * later when we call it, we will send the required implementation or create one on the fly,
	 * how cool is that.
	 */

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p)
	{
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;

	}//end method.




	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}//Ends inner Apple class.


	//The predicates interface and implementations.

	interface ApplePredicate{
		public boolean test(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate{
		public boolean test(Apple apple){

			return apple.getWeight() > 150;
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){

			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}



}
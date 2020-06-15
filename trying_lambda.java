import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.IntSummaryStatistics;

//Arrays.asList(intArray); 	or	Arrays.asList(1,2,3);

//Arrays.stream(intArray)
//IntStream.of(intArray)
//list1.stream()

class trying_lambda
{
	static int [] intArray = {6,2,9,4,5,1,7,8,3,10}; 
	
	public static void main (String [] args)
	{									
		System.out.printf("%15s", "IntStream.of: ");
		IntStream.of(intArray)
				 //.boxed()
				 .forEach (x -> System.out.print(x + "   "));
		
		System.out.printf("%n%15s", "Arrays.stream: ");		 
		Arrays.stream(intArray)
			  .forEach (x -> System.out.print(x + "   "));
			  
	
		List <Integer> list1 = IntStream.of(intArray)
										.sorted()
										.boxed()
										.collect(Collectors.toList());
											  
		System.out.printf("%n%15s", "list1.stream: ");
		list1.stream()
			 .forEach (x -> System.out.print(x + "   "));
			 
		List <Integer> list2 = Arrays.stream(intArray)
									 .sorted()
									 //.forEach (x -> System.out.print(x + "   "))
									 .boxed()
									 .collect(Collectors.toList());
		System.out.printf("%n%15s", "list2.stream: ");
		list2.stream()
			 .forEach (x -> System.out.print(x + "   "));
			
		List <Integer> myList = Arrays.asList(10,9,11,5,4,3,2,1);	
								//or insert intArray to convert, Arrays.asList(intArray)
		System.out.printf("%n%n%s%n", "myList.stream.forEach(System.out::println): ");
		myList.stream()
			  .filter(x -> x<=5)
			  .sorted()
			  .map(x -> x*2)
			  //.map(String::toLowerCase)	Same as .map(x -> x.toLowerCase())	
			  .forEach(System.out::println); //Same as (x -> System.out.println(x))
		
		int n = 5;	  
		//rangeList = {1,2,3,4,5}
		List <Integer> rangeList = IntStream.rangeClosed(1,n)	//including n
											.boxed()
											.collect(Collectors.toList());
								
			
		int sumOfList = rangeList.stream()
								//.distinct()
								//.sum()
								//.count()
								//.average()
								//.getAsDouble()	
				 				 .reduce(0,(num1,num2) -> num1+num2);	//sumOf {1,2,3,4,5} = 15... 0+15 = 20
		System.out.printf("%n%15s%d%n", "reduce(0..., +): ", sumOfList);
		
		sumOfList = rangeList.stream()
				 				 .reduce(5,(num1,num2) -> num1+num2);	//sumOf {1,2,3,4,5} = 15... 5+15 = 20
		System.out.printf("%15s%d%n", "reduce(5..., +): ", sumOfList);
		
		sumOfList = rangeList.stream()
				 				 .reduce(1,(num1,num2) -> num1*num2);	//1*{1,2,3,4,5}...
				 				 //start with *0 will always return 0, therefore reduce* must start with 1
		System.out.printf("%15s%d%n%n", "reduce(1..., *): ", sumOfList);
		
		IntSummaryStatistics s = IntStream.of (rangeList.stream()
					 									.mapToInt(x->x)
					 									.toArray())	//not important, convert List to Array
										  .summaryStatistics ();
		System.out.println (s);
	}
}
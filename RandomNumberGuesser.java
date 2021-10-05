/*
 * Class: CMSC203 
 * Instructor: David Kuijt 
 * Description: Build an application that will receive a guess and report if your 
 * 				guess is the random number that was generated.  Your application 
 * 				will narrow down the choices according to your previous guesses 
 * 				and continue to prompt you to enter a guess until you guess 
 * 				correctlyBuild an application that will receive a guess and report
 * 				if your guess is the random number that was generated. Your 
 * 				application will narrow down the choices according to your previous
 * 				guesses and continue to prompt you to enter a guess until you guess
 * 				correctly
 * Due: 10/04/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Esther Soon
*/


import java.util.Scanner;

public class RandomNumberGuesser {
	
		public static void main(String args[])
		{
			//Variables 
			int randNum, nextGuess;
			int lowGuess = 0;
			int highGuess = 100;
			String repeat;
			
			//Prints header
			System.out.println("==========Random Number Guessser==========");
			
			//Creating Scanner object
			Scanner input = new Scanner(System.in);
			
			do
			{
				//Gets random number
				randNum = RNG.rand();
				
				//Set high and low guess
				lowGuess = 0;
				highGuess= 100;
				
				//Reset random number counter
				RNG.resetCount();
				
				System.out.println("Enter your first guess");
				nextGuess = input.nextInt();
				
				while (nextGuess != randNum)
				{
					//Input validation
					do
					{
						if (RNG.inputValidation(nextGuess, lowGuess, highGuess)==false) 
						{
							nextGuess = input.nextInt();
						}
					} while (nextGuess>=highGuess || nextGuess<=lowGuess);
					
					//Displays number of guesses
					System.out.println("Number of guesses is "+ RNG.getCount() );
					
					//Display too high or too low depending on guessed number
					if(nextGuess>randNum)
					{
						System.out.println("Your guess is too high");
						highGuess = nextGuess;
					}
					else
					{
						System.out.println("Your guess is too low");
						lowGuess = nextGuess;
					}
					
					//Display range to guess and takes in guess
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					nextGuess = input.nextInt();
				}
				RNG.inputValidation(nextGuess, lowGuess, highGuess);
				
				System.out.println("Number of guesses is "+ RNG.getCount() );
				System.out.println("Congraturations, you guessed correctly");
				System.out.println("Try again? (yes or no)");
				input.nextLine();
				repeat = input.nextLine();
				
				if (repeat.equals("yes"))
				{
					System.out.println();
					System.out.println();
				}
					
			} while (repeat.equals("yes"));
			
			System.out.println("Thanks for playing...");
			
			//Close scanner
			input.close();
			
			//Print programmer name
			System.out.println();
			System.out.println("Programmer: Esther Soon");
		}
}

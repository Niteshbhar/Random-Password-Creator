import java.util.Scanner;
 class Printer
 //printer class will act as a parent class
 // which will be extended   by a child class
{
    //Create a function that prints out an array ,
    //that is passed in as a parameter.
	public static void printArray(StringBuilder[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	  

	//the upcoming method will going to checks the 
	// the strength of the passwords
	public static void password_checks(int length)
	{
		if(length<=5)
		{
			System.out.println("-------Your password is weak------ ");
			System.out.println("Please enhance its strength ");
		}
		else 
		if(length>=6&&length<=10)
		{
			System.out.println("-------Your password is of medium strength------ ");
			System.out.println("Please enhance its strength ");
		}
		else 
		{
			System.out.println("-------Your password is of GOOD strength------ ");
		}
	}
	}

  //extends use to get the parent class properties in
  // java child class 
public class File extends Printer{
  public static void main(String[] args) {
		
		// Create a Scanner (import it above!) and ask the
        // User how many random passwords they want generated
		Scanner obj = new Scanner(System.in);
  
        //this Scanner class helps to take inputs from user. 

		System.out.print("How many random passwords do you want to generate? ");
        //ask user to enter the numbers of passwords they wants
		int total = obj.nextInt();

		//Ask the user how long they want their random passwords to be
        //or say length of the passowrd
		System.out.print("How long do you want your random passwords to be? ");
		int length = obj.nextInt();

		//Create an array of random passwords (Strings)
        //this array will going to helps us to store the different passwords 
		StringBuilder[] randomPasswords = new StringBuilder[total];

		//Randomly generate passwords total number of times
		for(int i = 0; i < total; i++)
        {
			//Create a variable to store the random password
			StringBuilder randomPassword=new StringBuilder("");  
            //An empty string
			//Randomly generate a character for the password length number of times
			for(int j = 0; j < length; j++) {
				//Add a random lowercase or UPPERCASE character to our randomPassword String
				randomPassword.append( randomCharacter());
			}
			//Add the random password to your array
			randomPasswords[i] = randomPassword;
		}

		//Print out the random passwords array
        // here we will use object oriented programming concepts
	     // mainly known as oops
        printArray(randomPasswords);
		password_checks(length);


  }


	

	//Create a function that randomly generates a letter (lowercase or uppercase) or number (0-9) using ASCII
	//'0' - '9' => 48-57 in ASCII
	//'A' - 'Z' => 65-90 in ASCII
	//'a' - 'z' => 97-122 in ASCII
	
    
    
    
    public static char randomCharacter() {
		//We multiply Math.random() by 62 because there are 26 lowercase letters, 26 uppercase letters, and 10 numbers, and 26 + 26 + 10 = 62
		//This random number has values between 0 (inclusive) and 62 (exclusive)
		int rand = (int)(Math.random()*62);
		
		//0-61 inclusive = all possible values of rand
		//0-9 inclusive = 10 possible numbers/digits
		//10-35 inclusive = 26 possible uppercase letters
		//36-61 inclusive = 26 possible lowercase letters
		//If rand is between 0 (inclusive) and 9 (inclusive), we can say it's a number/digit
		//If rand is between 10 (inclusive) and 35 (inclusive), we can say it's an uppercase letter
		//If rand is between 36 (inclusive) and 61 (inclusive), we can say it's a lowercase letter
		if(rand <= 9) {
			//Number (48-57 in ASCII)
			//To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
			int number = rand + 48;
			//This way, rand = 0 => number = 48 => '0'
			//Remember to cast our int value to a char!
			return (char)(number);
		} else if(rand <= 35) {
			//Uppercase letter (65-90 in ASCII)
			//To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
			int uppercase = rand + 55;
			//This way, rand = 10 => uppercase = 65 => 'A'
			//Remember to cast our int value to a char!
			return (char)(uppercase);
		} else {
			//Lowercase letter (97-122 in ASCII)
			//To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
			int lowercase = rand + 61;
			//This way, rand = 36 => lowercase = 97 => 'a'
			//Remember to cast our int value to a char!
			return (char)(lowercase);
		}
	}
}

import java.util.Scanner;

public class Ex1 {
	private String subject; //input string
	private static char[] emptyArray; 
	private static char[] arrayOfWordChar;
    private String a;
	public static void main(String[] args) {
		
		System.out.println("Write something!");

		Scanner in = new Scanner(System.in);

		String subject = in.nextLine();

		System.out.println("You create: " + subject);
		String[] arrayOfWords = subject.split(" "); 

		for (int i = 0; i < arrayOfWords.length; i++) { 
			int lengthWord = arrayOfWords[i].length(); 
			char[] arrayOfWordChar = arrayOfWords[i].toCharArray(); 
			emptyArray = new char[arrayOfWordChar.length];
			
			for (int j = arrayOfWordChar.length - 1; j >= 0; j--) { 
				if (!Character.isAlphabetic(arrayOfWordChar[j])) {
					emptyArray[j] = arrayOfWordChar[j];
				}
			}

			for (int j = arrayOfWordChar.length - 1; j >= 0; j--) { 
				if (Character.isAlphabetic(arrayOfWordChar[j])) {
					for (int i1 = 0; i1 < emptyArray.length; i1++) {
						if (emptyArray[i1] == 0) {
							emptyArray[i1] = (arrayOfWordChar[j]);
							break;
						}
					}
				}
			}
			StringBuilder resultString = new StringBuilder();
			for (char elementOf : emptyArray) { 
				resultString.append(elementOf);
			}
			arrayOfWords[i] = resultString.toString(); 
			resultString = null;
		}
		System.out.print("Result:     ");
		for (String words : arrayOfWords) {
			System.out.print(words + " "); 
		}
	}

}

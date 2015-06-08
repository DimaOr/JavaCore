import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public String period = "";
	

	public void resultOutput(int number1 , int number2 ) {
		System.out.println(number1 + " |" + number2);
		String numberString = String.valueOf(number1);
		char[] charStringOfNumber = numberString.toCharArray();
		int charNumberLength = charStringOfNumber.length;
		boolean isLast = false;
		String a = "";
		String result = "";
		for (int i = 0; i < charStringOfNumber.length; i++) {

			a += String.valueOf(charStringOfNumber[i]);
			if (a.startsWith("0") && a.endsWith("0")) {
				System.out.println();
				System.out.println("----------");
				result += "0";
				System.out.println(result);
			}
			if (i == charStringOfNumber.length - 1) {
				isLast = true;
			}
			if (Integer.parseInt(a) / number2 < 1) {
				continue;

			} else {
				System.out.println();
				System.out.println("----------");
				result += String.valueOf(Integer.parseInt(a) / number2);
				
				System.out.print(result);
				if (isLast) {
					int rest = Integer.parseInt(a) % number2;
					if (rest == 0) {

						a = "";
					} else {
						a = String.valueOf(rest);
					}

				}
				if (isLast) {
					int[] afterDote = new int[100];
					for (int d = 0; d < 100; d++) {
						int number = Integer.parseInt(a) / number2;
						if (a.equals("0")) {
							break;
						}
						if (number < 1) {
							a += "0";
							number = Integer.parseInt(a) / number2;
						}
						if (number >= 1) {
							afterDote[d] = number;
							int restTo = Integer.parseInt(a) % number2;
							a = String.valueOf(restTo);

						} else {
							a = String.valueOf(number);
						}

					}

					System.out.print(".");
					String m =arrayLastResult(afterDote);
					System.out.print(m);
					;
					
					
					

				}
				int rest = Integer.parseInt(a) % number2;
				if (rest == 0) {

					a = "";
				} else {
					a = String.valueOf(rest);
				}

			}
		}
	}

	public String arrayLastResult(int[] a) {
		int arrayLength = a.length;
		ArrayList<Integer> firstNumber = new ArrayList<Integer>();
		ArrayList<Integer> lastNumber = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			firstNumber.add(a[i]);
		}

		for (int i1 = arrayLength - 30; i1 < arrayLength; i1++) {
			if (lastNumber.size() == 0) {
				lastNumber.add(a[i1]);
			} else {
				if (!lastNumber.contains(a[i1])) {
					lastNumber.add(a[i1]);
				}
			}
		}
		int hasPeriod = lastNumber.size();
		if (hasPeriod <= 5) {
			if (firstNumber.containsAll(lastNumber)) {
				for (int i = 0; i < firstNumber.size(); i++) {
					if (!lastNumber.contains(a[i])) {
						period += a[i];
					} else {
						int m = i;
						if (lastNumber.contains(a[m])
								&& lastNumber.contains(a[m + 1])
								&& lastNumber.contains(a[m + 2])
								&& lastNumber.contains(a[m + 3])
								&& lastNumber.contains(a[m + 4])
								&& lastNumber.contains(a[m + 5])
								&& lastNumber.contains(a[m + 6])) {
							String s = a[m] + "" + "" + a[m + 1] + ""
									+ a[m + 2];
							String result = s.substring(0, lastNumber.size());

							period += "(" + result + ")";
							break;
						}
					}
				}

			} else {
				period += "We dont find period on first 10 numbers";
			}
		} else {
			for (int withOutPeriod : a) {
				period += withOutPeriod;
			}

		}

		return period;
	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("write number 1 ");
		int a= in.nextInt();
		System.out.println("write number 2 ");
		int b = in.nextInt();
		Main main = new Main();
		main.resultOutput(a,b);

	}
}

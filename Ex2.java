import java.util.Scanner;


public class Ex2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number1= in.nextInt();
		int number2= in.nextInt();
		if (number1%number2==0){
			System.out.println(number1+" |" + number2);
			String numberString = String.valueOf(number1);
			char []	charStringOfNumber = numberString.toCharArray();
			String a ="";
			String result="";
			for(int i=0; i<charStringOfNumber.length; i++){
				
				a += String.valueOf(charStringOfNumber[i]);
				if (a.startsWith("0") && a.endsWith("0")){
					System.out.println("----------");
					result+="0";
					System.out.println(result);
				}
				if(Integer.parseInt(a)/number2<1){
					continue;
					
				}
				else{
					System.out.println("----------");
					result += String.valueOf(Integer.parseInt(a)/number2);
					System.out.println(result);
					int rest= Integer.parseInt(a)%number2;
					if(rest==0){
						
						a="";
					}
					else{
						a=String.valueOf(rest);
					}
				}
			}
		}else
		{
			System.out.println("no divid!");
		}
	}

}

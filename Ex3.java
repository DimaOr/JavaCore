import java.util.ArrayList;


public class Ex3p {
	ArrayList <Integer>  afterDote = new ArrayList <Integer>();
	String period = "";
	String ss="";
	public String arrayLastResult(ArrayList<Integer> a) {
		String fullResult="";
		for (int fullperiod : a) {
			fullResult+= fullperiod;
		}
		
		int arrayLength = a.size();
		if (a.size()<100){
			for (int withOutPeriod : a) {
				period += withOutPeriod;
			}
			
		}
		else { 
			
			ArrayList<Integer> firstNumber = new ArrayList<Integer>();
			ArrayList<Integer> lastNumber = new ArrayList<Integer>();

			for (int i = 0; i < a.size(); i++) {
				firstNumber.add(a.get(i));
			}

			for (int i1 = arrayLength - 30 ; i1 < arrayLength; i1++) {
				if (lastNumber.size() == 0) {
					lastNumber.add(a.get(i1));
				} else {
					if (!lastNumber.contains(a.get(i1))) {
						lastNumber.add(a.get(i1));
					}
				}
			}
			int hasPeriod = lastNumber.size()-1;
			int hasPeriodsize= lastNumber.size();
		
//			for (int i=a.size()-1; i>=0;i--){
//				int hasNumberinPeriod =a.get(i);
//				if (!lastNumber.contains(hasNumberinPeriod)){
//					period = fullResult.substring(0, i)+"("+fullResult.substring(i+1,i+lastNumber.size())+")";
//					
//					
//					break;
//					
//				}
//			}
			while(hasPeriodsize>=0){
				if((lastNumber.contains(a.get(hasPeriodsize)))){
					period = fullResult.substring(0, hasPeriodsize)+"("+fullResult.substring(hasPeriodsize,hasPeriodsize+hasPeriodsize)+")";
					
					break;
				}
				else{
					hasPeriod--;
				}
			
			}
			
//			if (hasPeriod <= 5) {
//				if (firstNumber.containsAll(lastNumber)) {
//					for (int i = 0; i < firstNumber.size(); i++) {
//						if (!lastNumber.contains(a.get(i))) {
//							period += a.get(i);
//						} else {
//							int m = i;
//							if (lastNumber.contains(a.get(m))
//									&& lastNumber.contains(a.get(m+1))
//									&& lastNumber.contains(a.get(m+2))
//									&& lastNumber.contains(a.get(m+3))
//									&& lastNumber.contains(a.get(m+4))
//									&& lastNumber.contains(a.get(m+5))
//									&& lastNumber.contains(a.get(m+6))) {
//								String s = a.get(m)+ "" + "" + a.get(m+1) + ""
//										+ a.get(m+2);
//								String result = s.substring(0, lastNumber.size());
//
//								period += "(" + result + ")";
//								break;
//							}
//						}
//					}
//
//				} else {
//					period += "We dont find period on first 10 numbers";
//				}
//			} else {
//				for (int withOutPeriod : a) {
//					period += withOutPeriod;
//				}
//
//			}

			
		}
		return period;
		}
	
public String getResult(int number1, int number2){
	 

	System.out.println(number1 + " |" + number2);
	String numberString = String.valueOf(number1);
	char[] charStringOfNumber = numberString.toCharArray();
	int charNumberLength = charStringOfNumber.length;
	boolean isLast = false;
	String a = "";
	String result = "";
	String resultNumber="";
	for (int i = 0; i < charStringOfNumber.length; i++) {

		a += String.valueOf(charStringOfNumber[i]);
		if (a.startsWith("0") && a.endsWith("0")) {
		
			System.out.print("----------");
			System.out.println();
			result += "0";
			System.out.println(result);
		}
		if (i == charStringOfNumber.length - 1) {
			isLast = true;
		}
		if (number1 < number2) {
			i=charStringOfNumber.length-1;
			//a = String.valueOf(Integer.parseInt(a) % number2);
			//int[] afterDote = new int[100];
			ArrayList <Integer>  afterDote = new ArrayList <Integer>();
			while ( afterDote.size()!=100) {
				if (a.equals("")){
					a="0";
					break;
				}
				
				int number = Integer.parseInt(a) / number2;
				
				if (number < 1) {
					
					a+="0";
					number = Integer.parseInt(a) / number2;
					//afterDote.add(0) ;
				}
				if (a.equals("0")) {
					break;
				}
				if (number < 1) {
					
//					a+="0";
//					number = Integer.parseInt(a) / number2;
					afterDote.add(0) ;
				}
				if (number >= 1) {
					afterDote.add(number) ;
					int restTo = Integer.parseInt(a) % number2;
					if (restTo == 0) {

						a = "";
					} else {
						a = String.valueOf(restTo);
					}
					

				} 

			}

			result=("0.") + arrayLastResult(afterDote) ;
			
			
		}
		if(  Integer.parseInt(a) / number2 < 1 ){
			continue;
		}
		 else {
			
			 result +="----------" + "\n";
			 resultNumber+= String.valueOf(Integer.parseInt(a) / number2);
			 result+=resultNumber +"\n";
//			System.out.println();
			if(isLast){
				
				int rest = Integer.parseInt(a) % number2;
				if (rest == 0) {

					a = "";
				} else {
					a = String.valueOf(rest);
				}
				
			}
			if (isLast) {
				
				//int[] afterDote = new int[100];
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
						afterDote.add(number);
						int restTo = Integer.parseInt(a) % number2;
						a = String.valueOf(restTo);

					} else {
						a = String.valueOf(number);
					}

				}

			
				result +="----------" + "\n";
				result+=resultNumber+"."+arrayLastResult(afterDote);
			}
			int rest = Integer.parseInt(a) % number2;
			if (rest == 0) {

				a = "";
			} else {
				a = String.valueOf(rest);
			}

		}
	}
	return result;

	
}
	
	
	public static void main(String[] args) {
	  Ex3p ex = new Ex3p();
	  String m =ex.getResult(10000, 126);
	  
	  System.out.println(m);
	}
}

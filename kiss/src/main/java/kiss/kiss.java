package com.epam.kiss;
public class Kiss{
	public static void main(String[] args) {
		try {
			System.out.println(month(0));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
private static String month(int m) throws Exception{
		if((m<1)||(m>12)) throw new Exception("month must be in range 1 to 12");
		String[] months= {
				"January" ,
				"February" ,
				"March" ,
				"April"  ,
				"May "  ,
				"June"  ,
				"July"  ,
				"August" ,
				"September", 
				"October" ,
				"November" , 
				"December"  
		};
		return months[m-1];
				
		}
		
	}
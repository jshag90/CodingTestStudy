package com.ji.main;

public class Question1 {
	
	public static void main(String[] args) {
		
		
		 int priceCount = 4000;
//		 int priceCount = 10;

		    // 가격정보 배열
		    int[] priceArray = new int[priceCount];
		    
		    for (int priceArrayIdx = 1; priceArrayIdx < priceCount; priceArrayIdx++  ) {
		        priceArray[priceArrayIdx-1] = priceArrayIdx * 1000;
		    }
		    
		    for(int price : priceArray) {
		    	System.out.println(price);
		    }
		    System.out.println("가격의 배열인덱스 : "   +getSearchPriceArrayIntex(priceArray, 690000));
		
	}
	
	public static int getSearchPriceArrayIntex(int[] priceArray, int searchPrice) {
		
		int index = 0;
		boolean isSearchPrice = false; //배열안에 검색할 금액이 없는 예외처리
		
	    for(int price : priceArray) {
	    	index++;
	    	if(price == searchPrice) {
	    		isSearchPrice = true;
	    		break;
	    	}
	    }
		
	    return isSearchPrice==true?index:-1;

	}

}


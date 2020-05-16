package com.ji.main;

public class Question1 {
	
	public static void main(String[] args) {
		
		
		 int priceCount = 4000;
//		 int priceCount = 10;

		    // �������� �迭
		    int[] priceArray = new int[priceCount];
		    
		    for (int priceArrayIdx = 1; priceArrayIdx < priceCount; priceArrayIdx++  ) {
		        priceArray[priceArrayIdx-1] = priceArrayIdx * 1000;
		    }
		    
		    for(int price : priceArray) {
		    	System.out.println(price);
		    }
		    System.out.println("������ �迭�ε��� : "   +getSearchPriceArrayIntex(priceArray, 690000));
		
	}
	
	public static int getSearchPriceArrayIntex(int[] priceArray, int searchPrice) {
		
		int index = 0;
		boolean isSearchPrice = false; //�迭�ȿ� �˻��� �ݾ��� ���� ����ó��
		
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


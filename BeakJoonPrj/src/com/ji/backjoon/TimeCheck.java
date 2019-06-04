package com.ji.backjoon;

public class TimeCheck {

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //시작하는 시점 계산
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");

	}

}

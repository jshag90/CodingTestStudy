package com.sundayalgo.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoDayThreadPoolMain {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(4);

		BufferedReader in = new BufferedReader(new FileReader("170604 - 알고리즘 sample02.txt"));
		String textLine = null;
		int lineIndex = 0;

		while ((textLine = in.readLine()) != null) {
			lineIndex++;
			textLine = in.readLine();
			Runnable worker = new TwoDayWorkerThread(args, textLine, lineIndex, in);
			executor.execute(worker);
		}

		in.close();
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		long end = System.currentTimeMillis();
		long resultTime = (end - start);
		System.out.println("speed result : " + resultTime);

	}

}

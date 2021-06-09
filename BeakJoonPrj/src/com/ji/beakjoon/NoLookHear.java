package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 듣보잡
 * @author ji
 *
 */
public class NoLookHear {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] noLookHearCountStr = br.readLine().split(" ");
		
		int noHearPersonCnt = Integer.valueOf(noLookHearCountStr[0]);
		int noLookPersonCnt = Integer.valueOf(noLookHearCountStr[1]);
		
		List<String> noHearNamesList = new ArrayList<String>();
		List<String> noLookHearList = new ArrayList<String>();
		
		for(int i=0; i<noHearPersonCnt; i++) 
			noHearNamesList.add(br.readLine());
		
		for(int i=0; i<noLookPersonCnt; i++) {
			String name =br.readLine();
			if(noHearNamesList.contains(name))
				noLookHearList.add(name);
		}
		
		Collections.sort(noLookHearList);
		bw.write(String.valueOf(noLookHearList.size())+"\n");
		for(String name:noLookHearList)
			bw.write(String.valueOf(name)+"\n");

		br.close();
		bw.flush();
		bw.close();
	}
}

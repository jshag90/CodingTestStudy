package com.ji.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotFactoryKakaoBank {

	public static Set<int[]> output = new HashSet<int[]>();
	static Set<EquipVO> equipList = new HashSet<EquipVO>();

	public static void main(String[] args) {

		System.out.println(solution(
				new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }, 2));
	}

	public static int solution(int[][] needs, int r) {
		int result = 0;
		Set<Integer> equipType = new HashSet<Integer>();
		for (int x = 0; x < needs.length; x++) {
			for (int y = 0; y < needs[x].length; y++) {

				if (needs[x][y] == 1) {

					EquipVO savedVO = null;
					for (EquipVO vo : equipList) {
						if (vo.getPrdNum() == x)
							savedVO = vo;
					}
					equipList.remove(savedVO);
					equipType.add(y);

					if (savedVO == null) {
						List<Integer> needEquipList = new ArrayList<>();
						needEquipList.add(y);
						equipList.add(new EquipVO(x, needEquipList));
					} else {
						savedVO.getEquipNum().add(y);
						equipList.add(new EquipVO(x, savedVO.getEquipNum()));
					}

				}

			}

		}

		for (EquipVO vo : equipList) {
			System.out.println(String.valueOf(vo.getPrdNum()) + String.valueOf(vo.getEquipNum()));
		}

		int[] typeArr = new int[equipType.size()];
		int index = 0;
		for (Integer type : equipType)
			typeArr[index++] = type;
		
		per1(typeArr, 0, equipType.size(), r);
		

		return result;
	}

	static void per1(int[] arr, int depth, int n, int r) {
		if (depth == r) {

			output.add(arr);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { // 두 배열의 값을 바꾸는 Swap 함수
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}

class EquipVO {
	int prdNum;
	List<Integer> equipNum;

	public EquipVO(int prdNum, List<Integer> equipNum) {
		super();
		this.prdNum = prdNum;
		this.equipNum = equipNum;
	}

	public int getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}

	public List<Integer> getEquipNum() {
		return equipNum;
	}

	public void setEquipNum(List<Integer> equipNum) {
		this.equipNum = equipNum;
	}

}

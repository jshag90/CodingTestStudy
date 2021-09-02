package com.ji.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RobotFactoryKakaoBank {
	
	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{1, 0, 0}, {1,1,0}, {1,1,0}, {1,0,1}, {1,1,0}, {0,1,1}}, 2));
	}
	
	public static int solution(int[][] needs, int r) {
		
		int result = 0;
		Set<EquipVO> equipList = new HashSet();
		for(int x=0; x<needs.length; x++) {
			
			for(int y=0; y<needs[x].length; y++) {
				
				if(needs[x][y] == 1) {
					
					EquipVO savedVO = null;
					for(EquipVO vo : equipList) {
						if(vo.getPrdNum() == x) {
							savedVO = vo;
						}
					}
					equipList.remove(savedVO);
						
					if(savedVO == null) {
						List<Integer> needEquipList = new ArrayList<>();
						needEquipList.add(y);
						equipList.add(new EquipVO(x, needEquipList));
					}else {
						savedVO.getEquipNum().add(y);
						equipList.add(new EquipVO(x, savedVO.getEquipNum()));
						
					}
					
				}
				
				
			}
			
		}
		
		for(EquipVO vo : equipList) {
			System.out.println(String.valueOf(vo.getPrdNum()) + String.valueOf(vo.getEquipNum()));
		}
		
		
		return result;
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


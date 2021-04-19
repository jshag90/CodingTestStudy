package com.sundayalgo.threeday;

import java.util.ArrayList;
import java.util.List;

public class SegementCalculate {

	private static final char[] CHO =
			/* �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� */
			{ 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145, 0x3146, 0x3147, 0x3148,
					0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	private static final char[] JUN =
			/* �������¤äĤŤƤǤȤɤʤˤ̤ͤΤϤФѤҤ� */
			{ 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158, 0x3159, 0x315a, 0x315b,
					0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };
	/* X ������������������������������������������������������ */
	private static final char[] JON = { 0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
			0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147, 0x3148,
			0x314a, 0x314b, 0x314c, 0x314d, 0x314e };

	public static List<Integer> ln(String name) {

		int segmentSum = 0;

		List<Integer> resultlList = new ArrayList<Integer>();

		for (int i = 0; i < name.length(); i++) {

			char str = name.charAt(i);

			char uniVal = (char) (str - 0xAC00);
			char cho = (char) (((uniVal - (uniVal % 28)) / 28) / 21);
			char jun = (char) (((uniVal - (uniVal % 28)) / 28) % 21);
			char jon = (char) (uniVal % 28);

			int choSegement = choCalcuSegemnt(CHO[cho]);
			int junSegement = junCalcuSegemnt(JUN[jun]);
			int jonSegement = jonCalcuSegemnt(JON[jon]);
			segmentSum = choSegement + junSegement + jonSegement;

			resultlList.add(segmentSum);
		}

		return resultlList;

	}

	private static int choCalcuSegemnt(char hexString) {
		// TODO Auto-generated method stub
		int result = 0;

		if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 1;

		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 2;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 3;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {

			result = 4;
		} else if (String.valueOf(hexString).equals("��")) {

			result = 5;
		}

		return result;
	}

	private static int junCalcuSegemnt(char hexString) {
		// TODO Auto-generated method stub
		int result = 0;

		if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {

			result = 1;

		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 2;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 3;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 4;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {

			result = 5;
		}

		return result;
	}

	private static int jonCalcuSegemnt(char hexString) {
		int result = 0;

		if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 1;

		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 2;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��")) {

			result = 3;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {

			result = 4;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {

			result = 5;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")
				|| String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {
			result = 6;
		} else if (String.valueOf(hexString).equals("��") || String.valueOf(hexString).equals("��")) {
			result = 7;
		}

		return result;
	}

}

package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.commons.lang3.ArrayUtils;

public class start {

	private static Logger logger = Logger.getLogger(start.class.getName());

	// �إ߼��J�P����
	// �®�
	private static final String[] spades = new String[] { "s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10",
			"s11", "s12", "s13" };
	// ����
	private static final String[] hearts = new String[] { "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10",
			"h11", "h12", "h13" };
	// ���
	private static final String[] diamonds = new String[] { "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10",
			"d11", "d12", "d13" };
	// ����
	private static final String[] clubs = new String[] { "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10",
			"c11", "c12", "c13" };

	private static String[] poker = null;

	public static void main(String[] args) {

		poker = ArrayUtils.addAll(spades, hearts);
		poker = ArrayUtils.addAll(poker, diamonds);
		poker = ArrayUtils.addAll(poker, clubs);

		Scanner scn = new Scanner(System.in);
		System.out.print("�п�J���a�H��:");
		String player = scn.nextLine();
		System.out.println("�`�@" + player + "�쪱�a");

		shuffle();
		deal(player);

	}

	/**
	 * �~�P
	 */
	private static void shuffle() {
//		System.out.println("�~�P�e���J�P:" + Arrays.toString(poker));
		Random r = new Random();
		int i = 0;
		while (i++ < 10000) {

			// ��X�n�洫��A�MB��m
			int indexA = r.nextInt(52);
			int indexB = r.nextInt(52);

			if (indexA == indexB) {
//				System.out.println("��" + i + "��, A = " + indexA + ", B = " + indexB + ", �ۦP���L");
			} else {
				String a = poker[indexA];
				String b = poker[indexB];
				poker[indexA] = b;
				poker[indexB] = a;
			}

		}
//		System.out.println("�~�P�ἳ�J�P:" + Arrays.toString(poker));
	}

	/**
	 * �o�P
	 * 
	 * @param str
	 *            ���a�H��
	 */
	private static void deal(String player) {
		try {
			int number = Integer.parseInt(player);

			List<ArrayList<String>> playerList = new ArrayList<ArrayList<String>>();
			for (int k = 0; k < number; k++) {
				playerList.add(new ArrayList<String>());
			}
			
			int i = 0;
			while (i < 52) {
				for (ArrayList<String> playerCard : playerList) {
					if (i < 52) {
						playerCard.add(poker[i]);
						i += 1;
					} else
						break;
				}
			}

			for (int j = 0; j < number; j++) {
				ArrayList<String> playerCard = playerList.get(j);
				System.out.println("���a" + (j + 1) + "���P:" + Arrays.toString(playerCard.toArray()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

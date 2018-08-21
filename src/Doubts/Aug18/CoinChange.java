package Doubts.Aug18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Aug-2018
 */

public class CoinChange {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 3, 6 };

		System.out.println(coinChangeR(arr, 0, 10));
		System.out.println(coinChangeBU(arr, 10));

	}

	public static int coinChangeR(int[] coins, int vidx, int amount) {

		if (amount == 0) {
			return 1;
		}
		if (vidx == coins.length || amount < 0) {
			return 0;
		}

		int ans = 0;
		ans += coinChangeR(coins, vidx + 1, amount); // coin is not participating
		ans += coinChangeR(coins, vidx, amount - coins[vidx]); // coin is participating

		return ans;
	}

	public static int coinChangeBU(int[] coins, int amount) {

		int[] strg = new int[amount + 1];

		strg[0] = 1;
		for (int coin : coins) {

			for (int i = coin; i < strg.length; i++) {
				strg[i] += strg[i - coin];
			}
		}

		return strg[amount];

	}

}

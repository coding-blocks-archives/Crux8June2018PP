package L3_June14;

public class Temp {

	public static void main(String[] args) {

		int minF = 0;
		int maxF = 100;
		int step = 20;

		for (int i = minF; i <= maxF; i += step) {

			int c = (int)((5.0 / 9) * (i - 32));
			System.out.println(i + "\t" + c);
		}

	}

}

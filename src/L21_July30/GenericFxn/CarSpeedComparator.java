package L21_July30.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2018
 */

public class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return o1.speed - o2.speed;
	}

}

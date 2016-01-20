package com.own.gameengine.math;


public class MathUtil {
	
	/**
	 * Compares if two float values are equal with a tolerance.
	 * 
	 * @param value1
	 *            The first float value.
	 * @param value2
	 *            The second float value.
	 * @param tolerance
	 *            The tolerance, with which the two float values are compared.
	 * @return Returns <code>true</code> if the difference of <code>value1</code> and <code>value2</code> is less than
	 *         <code>tolerance</code>.
	 * 		
	 * @see <a href="http://stackoverflow.com/a/4915891">stackoverflow.com/4915891</a>
	 */
	public static boolean floatNearlyEquals(final float value1, final float value2, final float tolerance) {
		float absValue1 = Math.abs(value1);
		float absValue2 = Math.abs(value2);
		float diff = Math.abs(value1 - value2);
		
		if (value1 == value2)
			return true;
		else if (value1 == 0 || value2 == 0 || diff < Float.MIN_NORMAL)
			return diff < (tolerance * Float.MIN_NORMAL);
		else
			return diff / (absValue1 + absValue2) < tolerance;
	}
}

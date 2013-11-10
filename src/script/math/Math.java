package script.math;

public class Math {

	static float invSqrt(float x) {
		float xhalf = 0.5f * x;
		int i = (int) x;
		// get bits for floating value
		i = 0x5f3759df - (i >> 1); // gives initial guess y0
		x = (float) i;
		// convert bits back to float
		x = x * (1.5f - xhalf * x * x);
		// Newton step, repeating increases accuracy
		return x;
	}

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(invSqrt(9.0f));
		long t2 = System.currentTimeMillis();
		System.out.println(java.lang.Math.sqrt(9.0f));
		long t3 = System.currentTimeMillis();
		System.out.println(t2-t1);
		System.out.println(t3-t2);

	}

}

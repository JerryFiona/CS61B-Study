/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        //return a.equals(b); or (int a, int b) works
        // == two object points to same instance
        // data type is Integer not int. Autoboxing caches -128 to 127
        return a == b;
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n = 1024;
		int m = 19;
		
		int i = 2;
		int j = 6;
		
		int mask = ~0 & (0<<j | ~(1 << i));
		int N = n & mask;
		int result = N | (m << i);
		
		System.out.println(result);
	}
}
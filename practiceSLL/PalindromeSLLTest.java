package practiceSLL;

public class PalindromeSLLTest {
	public static void main(String[] args) {
		LL linked1 = new LL();
		linked1.insert(1);
		linked1.insert(1);
		linked1.insert(2);
		linked1.insert(4);
		linked1.insert(4);
		linked1.insert(2);
		linked1.insert(1);
		linked1.insert(1);
		
		linked1.displayLinkedList();
		System.out.println();
		System.out.println(linked1.checkPalindrome());
		

	}

}

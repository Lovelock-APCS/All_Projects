
public class mathEquation {

	public static void main(String[] args) {
		for (int x = 1;x<1000;x++) {
			int c = x;
			int b = c/2;
			int a = b*2;
			if(b == c) {
				c = c/2;
			}
			else
				c = (3*c)+1;
		}

	}

}

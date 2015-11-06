package testprojects;

public class SquareLoops {

	public static final int START = 100;
	public static void main(String[] args) {
		for (int i = START; i >= 1; i--){
			int square = i * i;
			System.out.println(i + " squared is " + square);
		}

	}

}

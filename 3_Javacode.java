import java.time.LocalTime;class Main {public static void main(String[] args) {int st = LocalTime.now().getNano();Usercode.usercode();int et = LocalTime.now().getNano();System.out.println("forsplit" + (et - st) / (double)1000000000);}}class Usercode {static void usercode() {
		// Print the result of 12 divided by 3
		System.out.println(4);

		// Print the result of 3 times 6
		System.out.println(3 * 6);

		// Print the remainder of 8 %divided by 3
		System.out.println(2);

	}
}
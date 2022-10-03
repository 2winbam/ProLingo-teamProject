import java.time.LocalTime;class Main {public static void main(String[] args) {int st = LocalTime.now().getNano();Usercode.usercode();int et = LocalTime.now().getNano();System.out.println("forsplit걸린 시간 : " + (et - st) / (double)1000000000);}}class Usercode {static void usercode() {

		//This line should be a comment
		System.out.println("Hello Java");
	}
}
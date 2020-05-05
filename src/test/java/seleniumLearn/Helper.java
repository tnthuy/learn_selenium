package seleniumLearn;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {
	public static void pause(long s) throws InterruptedException {
		Thread.sleep(s);
	}
	public static void printCurrentTime() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now =LocalDateTime.now();
		System.out.println(dtf.format(now));
	}

}

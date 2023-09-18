package GenericUtils;

import java.util.Random;

public class JavaUtils {
	
	//JavaUtils.IMPLICIT_WAIT_TIME
	public static final int IMPLICIT_WAIT_TIME=30;
	
	public String getRandomEmail() {
		Random random=new Random();
		int ran=random.nextInt(30000);
		String email = "vivek"+ran+"@gmail.com";
		return email;
	}

}

package Assets;

import java.util.regex.Pattern;

public class ValidateMail {
	static boolean isValid(String rut) {
		return Pattern.matches("^[a-z0-9]+(?:.[a-z0-9]+){0,5}@[a-z0-9]+(?:.[a-z0-9]+){1,5}" , rut);
	}
}

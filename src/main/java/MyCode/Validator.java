package MyCode;

import java.util.regex.Pattern;

/**
 * Created by hillel on 30.06.17.
 */
public class Validator {

    private String patterNumbers = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patterEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";

    private String patterReplace = "(?:java|job|senior)";

    public Validator() {
    }

    public boolean numbers(String input) {
        return Pattern.matches(this.patterNumbers, input);
    }
    public boolean emails(String input)
    {
        return Pattern.matches(this.patterEmails, input);
    }

    public String replacement(String input, String replace){
        return input.replaceAll(this.patterReplace, replace);
    }
}

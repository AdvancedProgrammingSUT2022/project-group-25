package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandRegexes {

    public static Matcher userCreateRegex(String command) {
        return Pattern.compile("user create -(u|-username) (\\S+) -(p|-password) (\\S+) -(n|-nickname) (\\S+)").matcher(command);
    }

    public static Matcher userLoginRegex(String command) {
        return Pattern.compile("user login -(u|-username) (\\S+) -(p|-password) (\\S+)").matcher(command);
    }


    public static Matcher menuEnterRegex(String command, String regex) {
        return Pattern.compile(regex).matcher(command);
    }

    public static Matcher playerRegexCheck(String command, int i) {
        return Pattern.compile("-(p|-player)" + i + " (?<username>\\S+)").matcher(command);
    }


    public static Matcher nicknameChangeRegex(String command) {
        return Pattern.compile("profile change -(n|-nickname) (\\S+)").matcher(command);
    }

    public static Matcher changePasswordRegex(String command) {
        return Pattern.compile("profile change -(p|-password) -(c|-current) (\\S+) -(n|-new) (\\S+)").matcher(command);

    }
}

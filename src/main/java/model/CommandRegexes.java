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


    public static Matcher menuEnterRegex(String command) {
        return Pattern.compile("menu enter (login Menu|game Menu|profile Menu)").matcher(command);
    }

    public static Matcher playerRegexCheck(String command, int i) {
        return Pattern.compile("-(p|-player)" + i + " (?<username>\\S+)").matcher(command);
    }
}

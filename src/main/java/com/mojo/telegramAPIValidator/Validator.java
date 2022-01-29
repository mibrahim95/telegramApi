package com.mojo.telegramAPIValidator;

import java.util.ArrayList;
import java.util.List;


public class Validator {

    public List<String> getCurseWords() {
        List<String> curseWords = new ArrayList<>();
        curseWords.add("ass");
        curseWords.add("dick");
        curseWords.add("butt");
        curseWords.add("boobs");
        curseWords.add("fuck");
        curseWords.add("bitch");
        return curseWords;
    }

    public boolean isValidEmail(final String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    private boolean isValidStringLength(final String string, final int minLength, final int maxLength) {
        return string.length() >= minLength && string.length() < maxLength;
    }

    private boolean containsNoCurseWords(final String string) {
        List<String> curseWords = this.getCurseWords();
        return curseWords.stream().noneMatch(curseWord -> string.toLowerCase().contains(curseWord));
    }

    public boolean isValidString(final String String, final int minLength, final int maxLength) {
        return this.isValidStringLength(String, minLength, maxLength) && this.containsNoCurseWords(String);
    }
}

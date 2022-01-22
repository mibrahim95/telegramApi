package com.mojo.telegramAPIValidator;

import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Validator {

    public List<String> getCurseWords(){
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

    public boolean isValidStringLength(final String string, final int length) {
        return string.length() > 0 && string.length() < length;
    }

    public boolean isValidFullName(final String name){
        List<String> curseWords = this.getCurseWords();
        if(this.isValidStringLength(name,100)){
            return !(curseWords.stream().anyMatch(curseWord->name.toLowerCase().contains(curseWord)));
        }
        return false;
    }

    public boolean isValidMessage(final String message){
        List<String> curseWords = this.getCurseWords();
        if(this.isValidStringLength(message,300)){
            return !(curseWords.stream().anyMatch(curseWord->message.toLowerCase().contains(curseWord)));
        }
        return false;
    }
}

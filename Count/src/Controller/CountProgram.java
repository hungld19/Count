/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Validate;
import View.Menu;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author LAPTOP DELL
 */
public class CountProgram extends Menu<String>{
    
    static String[] mc = {"Letter and Charator Count", "Convert base number", "Exit"};
    String str;
    Validate l;

    public CountProgram() {
        super("PROGRAMMING", mc);
        l = new Validate();
        str = l.getString("Input string: ");
    }
    
    public void execute(int n) {
        switch (n) {
            case 1:
                countLetter(str);
                break;
            case 2:
                str = str.replaceAll("\\s+", "");
                countCharacter(str);
                break;
            case 3:
                System.exit(0);
        }
    }
    
    public void countLetter(String str) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String[] strSplit = str.split("\\s");
        StringTokenizer st = new StringTokenizer(str);
        int numberOfTokens;
        for(int i = 0; i < strSplit.length; i++) {
            String ch = strSplit[i];
            int count = 0;
            for(int j = 0; j < strSplit.length; j++) {
                if(strSplit[j].equals(ch)) {
                    count++;
                }
            }
            hm.put(ch, count);
        }
        hm.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        numberOfTokens = st.countTokens();
        System.out.println("The numbers of token in the string is: " + numberOfTokens);
    }
    
   public void countCharacter(String str) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j)==ch) {
                    count++;
                }
            }
            hm.put(ch+"", count);
        }
        
        hm.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }

}
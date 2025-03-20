package org.example.Arrays.isomorphic_strings_205;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));

        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic2("paper","tilte"));
        System.out.println(isIsomorphic2("paper","title"));
        System.out.println(isIsomorphic2("paper","tit"));

    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> charInS = new HashMap<>();
        HashMap<Character,Integer> charInT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!charInS.containsKey(s.charAt(i))) {
                charInS.put(s.charAt(i),i);
            }

            if(!charInT.containsKey(t.charAt(i))) {
                charInT.put(t.charAt(i),i);
            }

            if(!charInS.get(s.charAt(i)).equals(charInT.get(t.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Character ,Character> maps = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for(int i =0;i < t.length(); i++){
            char ch1 =s.charAt(i);
            char ch2 =t.charAt(i);
            if(!maps.containsKey(ch1)){
                if(maps.containsValue(ch2)) {
                    return false;
                }
                maps.put(ch1,ch2);
            }else{
                if(maps.get(ch1)!=ch2){
                    return false;
                }
            }
        }
        return true;
    }
}

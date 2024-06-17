package org.example.services;

public class Caeser {
    private final String Alphabet;


    public String getAlphabet() {
        return Alphabet;
    }

    public Caeser(String alphabet) {
        this.Alphabet = alphabet;
    }

    public char symbolEncode(char symbol,int key){
        for (int i = 0; i < Alphabet.length(); i++) {
            if(symbol==Alphabet.charAt(i)){
                return Alphabet.charAt((i+key)%Alphabet.length());
            }
        }
        return symbol;
    }

    public char symbolDecode(char symbol,int key){
        if(key>=Alphabet.length()){
            key=key%Alphabet.length();
        }
        for (int i = 0; i <Alphabet.length(); i++) {
            if(symbol==Alphabet.charAt(i)){
                if(key>i){
                    return Alphabet.charAt(Alphabet.length()-(key-i));
                }
                else return Alphabet.charAt(i-key);
            }
        }
        return symbol;
    }
}

package com.example.myapp;


public class FourPictures {

    private String targetWord;
    private String revealedWord;
    private String letters;
    private String[] pictureNames;
    private int gameWon=0;

    public FourPictures(String targetWord, String letters,
                        String[] pictureNames) {

        this.targetWord = targetWord;
        this.revealedWord = "";

        int temp = 0;
        temp = targetWord.length();
        for (int i = 0; i < temp; ++i){
            revealedWord = revealedWord + " _";
        }

        this.letters = letters;
        this.pictureNames = pictureNames;
    }

    public String getPhoto(int i){
        return pictureNames[i];
    }

    public String toString(){
        return targetWord+" "+letters+" "+revealedWord;
    }


    public String getRevealedWord(){
        return revealedWord;
    }

    public String getLetters(){
        return letters;
    }

    public int getGameWon(){
        return gameWon;
    }

    public String getTargetWord(){
        return targetWord;
    }

    public void processCharacter(String text) {
        char c=text.charAt(0);
        int j=0;
        String tmpRevWord="";
        for(int i=0; i<targetWord.length(); i++){

            if(c==targetWord.charAt(i)){
                tmpRevWord = tmpRevWord+c+" ";
            }
            else if (revealedWord.charAt(j)==targetWord.charAt(i)){
                tmpRevWord = tmpRevWord + revealedWord.charAt(j)+" ";
            }
            else {
                tmpRevWord = tmpRevWord + "_ ";
            }
            j+=2;
        }

        revealedWord = tmpRevWord;
        j=0;
        int won=1;

        for(int i=0; i<targetWord.length(); i++){
            if(revealedWord.charAt(j) != targetWord.charAt(i)) {
                won = 0;

                break;
            }
            j+=2;
        }

        if(won==1) {
            gameWon = 1;
        }

    }




}

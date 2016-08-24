package com.github.yuriy27.lib.beans;

public class LetterList {

    char[] letters;

    public char[] getRuusianLetters() {
        letters = new char['Я' - 'А' + 1];
        char c;
        int i;
        for (c = 'А', i = 0; c <= 'Я'; c++, i++) {
            letters[i] = c;
        }

        return letters;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Guilherme
 */
public class Trabalho_automatos_lexer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        //String tokenString = readFile("entrada.txt");

        String tokenString = readFile("input.txt");
        Lexer g = new Lexer(new TokenTypes());
        g.lex(tokenString);

    }

    public static String readFile(String filename) throws IOException {
        String everything = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                everything += sCurrentLine + " ";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return trimEnd(everything);
    }

    public static String trimEnd(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = s.length();
        while (i > 0 && Character.isWhitespace(s.charAt(i - 1))) {
            i--;
        }
        if (i == s.length()) {
            return s;
        } else {
            return s.substring(0, i);
        }
    }
}

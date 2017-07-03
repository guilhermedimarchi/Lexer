/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Guilherme
 */
public class Lexer {

    TokenTypes tokenTypes;
    HashSet<String> tokensJaValidados;

    public Lexer(TokenTypes tokenTypes) {
        this.tokenTypes = tokenTypes;
        tokensJaValidados = new HashSet();
    }

    public void lex(String input) {
        String ret = findToken(" " + input);
        System.out.println(ret);

    }

    public String findToken(String input) {
        input = input.toLowerCase();

        for (Token tk : tokenTypes.getTokenTypes()) {
            if (!"WHITESPACE".equals(tk.name) && !"GRAMATICA".equals(tk.name)) {
                input = input.replaceAll(tk.rule, " " + tk.name + " ");
            }
        }
        //System.out.println(input);
        String inputAux = input.replaceAll(tokenTypes.getToken("GRAMATICA").rule, "-");
        inputAux = inputAux.replaceAll(tokenTypes.getToken("WHITESPACE").rule, "");
        inputAux = inputAux.replaceAll("-+", " ");

        Pattern pattern = Pattern.compile(" ");
        String[] group = pattern.split(inputAux);
        for (String s : group) {
            if(!"".equals(s))
              input = input.replaceAll(s, "INVALIDO");
        }
        input = input.replaceAll("\\s+", " ");

        return input;
    }

    public static String replaceFirstOccurrenceOfString(String inputString, String stringToReplace,
            String stringToReplaceWith) {

        int length = stringToReplace.length();
        int inputLength = inputString.length();

        int startingIndexofTheStringToReplace = inputString.indexOf(stringToReplace);

        String finalString = inputString.substring(0, startingIndexofTheStringToReplace) + stringToReplaceWith
                + inputString.substring(startingIndexofTheStringToReplace + length, inputLength);

        return finalString;

    }
}

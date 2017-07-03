/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class TokenTypes {

    ArrayList<Token> tokenList = new ArrayList<Token>();

    public TokenTypes() {
        tokenList.add(new Token("PONTO", "\\."));
        tokenList.add(new Token("PONTOEVIRGULA", ";"));
        tokenList.add(new Token("VIRGULA", ","));
        tokenList.add(new Token("MATOP", "[*|/|+|-]"));
        tokenList.add(new Token("CMPOP", "==|\\<=|\\>=|\\!=|\\<|\\>"));
        tokenList.add(new Token("ATTR", "={1,1}"));
        tokenList.add(new Token("INTEGER", "\\b[0-9]+\\b"));
        tokenList.add(new Token("DECLARATION", "\\bint\\b"));
        tokenList.add(new Token("IF", "\\bif\\b"));
        tokenList.add(new Token("ELSE", "\\belse\\b"));
        tokenList.add(new Token("WHILE", "\\bwhile\\b"));
        tokenList.add(new Token("AND", "\\band\\b"));
        tokenList.add(new Token("OR", "\\bor\\b"));
        tokenList.add(new Token("LCHAVE", "\\{"));
        tokenList.add(new Token("RCHAVE", "\\}"));
        tokenList.add(new Token("LPARENTESIS", "\\("));
        tokenList.add(new Token("RPARENTESIS", "\\)"));
        tokenList.add(new Token("WHITESPACE", "\\s"));
        tokenList.add(new Token("VARIABLE", "\\b[a-z0-9][a-z0-9_]*\\b"));
        tokenList.add(new Token("GRAMATICA", "[PONTO|PONTOEVIRGULA|VIRGULA|VARIABLE|WHITESPACE|ATTR|RPARENTESIS|LPARENTESIS|WHILE|IF|ELSE|DECLARATION|INTEGER|MATOP|CMPOP|LCHAVE|RCHAVE]"));

    }

    public ArrayList<Token> getTokenTypes() {
        return tokenList;
    }

    public void remove(Token t) {
        tokenList.remove(t);
    }

    public Token getToken(String name) {
        for (Token tk : tokenList) {
            if (tk.name == name) {
                return tk;
            }
        }
        return null;
    }

}

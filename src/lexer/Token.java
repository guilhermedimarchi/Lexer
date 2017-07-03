/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author Guilherme
 */
public class Token {
    
    public String name;
    public String rule;

    public Token(String type, String data) {
      this.name = type;
      this.rule = data;
    }

    @Override
    public String toString() {
      return String.format("(%s %s)", name, rule);
    }
    
}

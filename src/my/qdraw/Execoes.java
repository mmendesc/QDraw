/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.qdraw;

/**
 *
 * @author JoaoCito
 */
public class Execoes extends Exception{
    public Execoes (String str){
        super(str);
    }
}
class MenorValor extends Exception{
    public MenorValor (String str){
        super(str);
    }
}
class MaiorValor extends Exception{
    public MaiorValor (String str){
        super(str);
    }
}
class Vazio extends Exception{
    public Vazio (String str){
        super(str);
    }
}
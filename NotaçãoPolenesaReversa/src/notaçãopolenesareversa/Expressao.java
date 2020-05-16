package notaçãopolenesareversa;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lucas Bergamin Dos Santos
 */
public class Expressao {
    private String expressao;
    private String sla, valida;
    private int contador, valor;
    private double num1, num2, resultado;
    Pilha pilha = new Pilha();
    Pilha p = new Pilha();
    Fila fila = new Fila();
    DecimalFormat df = new DecimalFormat("#0.00");
    
    public void resolva(String strExp){
        valor = 0;
        setExpressao(strExp);
        MostraExpressao();
        converte();
        MostraFila();
        Resolucao();
        MostraPilha();
        
    }
    
    
    public Expressao(){
        sla = "";
        contador = valor = 0; 
        num1 = num2 = resultado = 0;
        
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getExpressao() {
        return expressao;
        
    }

    public String getSla() {
        return sla;
    }

    public void setSla(String sla) {
        this.sla = sla;
    }
    
    public int Tamanho(){
        return getExpressao().length();
        
    }
    
    public void Verifica(String i){
        switch (i) {
            case "(":
                pilha.Empilhar(i);
                break;
            case "^":
                if("(".equals(pilha.ConsultarTopo()))
                {
                    pilha.Empilhar(i);
                }
                
                else if(pilha.Vazio())
                {
                    
                    pilha.Empilhar(i);
                }
                
                else if("^".equals(pilha.ConsultarTopo()))
                {
                    try {
                        fila.enfileirar(pilha.Desempilhar());
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pilha.Empilhar(i);
                }
                else
                {
                    pilha.Empilhar(i);
                }    break;
            case "*":
            case "/":
                if("(".equals(pilha.ConsultarTopo()))
                {
                    pilha.Empilhar(i);
                }
                
                else if(pilha.Vazio())
                {
                    pilha.Empilhar(i);
                }
                
                else if("^".equals(pilha.ConsultarTopo()) || "*".equals(pilha.ConsultarTopo()) || "/".equals(pilha.ConsultarTopo()))
                {
                    try {
                        fila.enfileirar(pilha.Desempilhar());
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pilha.Empilhar(i);
            }
                else
                {
                    pilha.Empilhar(i);
                }  break;
            case "-":
            case "+":
                if("(".equals(pilha.ConsultarTopo()))
                {
                    pilha.Empilhar(i);
                }

                else if(pilha.Vazio())
                {
                    pilha.Empilhar(i);
                }
                
                else if("^".equals(pilha.ConsultarTopo()) || "*".equals(pilha.ConsultarTopo()) || "/".equals(pilha.ConsultarTopo()) || "+".equals(pilha.ConsultarTopo()) || "-".equals(pilha.ConsultarTopo()))
                {
                    try {
                        fila.enfileirar(pilha.Desempilhar());
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pilha.Empilhar(i);
                    
                }
                else
                {
                    pilha.Empilhar(i);
                }   break;
            case ")":
                while(contador != 0){
                    if("(".equals(pilha.ConsultarTopo()))
                    {
                        pilha.Desempilhar();
                        contador--;
                    }
                    else{
                        try {
                            fila.enfileirar(pilha.Desempilhar());
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }       
                }
            }
                break;
        }
    }
    
    public void converte(){ 
        for(int i = 0;i<Tamanho();i++){ 
            switch(getExpressao().charAt(i)){ 
                case '(':{
                    contador++;
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    break; 
                } 

                case '^':{ 
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = ""; 
                    break; 

                } 
                case '*':{ 
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = ""; 
                    break; 
                } 

                case '/':{
                    
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = "";
                    break; 
                } 

                case '+':{ 
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = "";
                    break; 
                } 

                case '-':{
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = ""; 
                    break; 
                } 

                case ')':{
                    try { 
                        fila.enfileirar(sla);
                    } catch (Exception ex) {
                        Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Verifica(Character.toString(getExpressao().charAt(i)));
                    sla = "";
                    break; 
                }
             
                default:{ 
                    sla += Character.toString(getExpressao().charAt(i));
                    
                }               
            }
        }
        try {
            fila.enfileirar(sla);
        } catch (Exception ex) {
            Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!pilha.Vazio()){
            while(!(pilha.Vazio())){
                try {
                    fila.enfileirar(pilha.Desempilhar());
                } catch (Exception ex) {
                    Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
        
    }
    
    public void Resolucao(){
        
        while(!fila.filaVazia()){
            try {
                valida = fila.desenfileirar();
                if(!"+".equals(valida) && !"-".equals(valida) && !"*".equals(valida) && !"/".equals(valida) && !"^".equals(valida)){
                    p.Empilhar(valida);
                }
                
                else if("+".equals(valida)){
                    try{
                        num1 = Double.parseDouble(p.Desempilhar()); 
                        num2 = Double.parseDouble(p.Desempilhar()); 
                        resultado = num2 + num1; 
                        p.Empilhar(Double.toString((double) resultado));
                    }catch(Exception e){
                        System.out.println("Erro na montagem da expressão");
                    }
                }
                
                else if("-".equals(valida)){
                    try{
                        num1 = Double.parseDouble(p.Desempilhar()); 
                        num2 = Double.parseDouble(p.Desempilhar()); 
                        resultado = num2 - num1; 
                        p.Empilhar(Double.toString((double) resultado));
                    }catch(Exception e){
                        System.out.println("Erro na montagem da expressão");
                    }
                }
                
                else if("*".equals(valida)){
                    try{
                        num1 = Double.parseDouble(p.Desempilhar()); 
                        num2 = Double.parseDouble(p.Desempilhar()); 
                        resultado = num2 * num1; 
                        p.Empilhar(Double.toString((double) resultado));
                    }catch(Exception e){
                        System.out.println("Erro na montagem da expressão");
                    }
                }
                
                else if("/".equals(valida)){
                    try{
                        num1 = Double.parseDouble(p.Desempilhar()); 
                        num2 = Double.parseDouble(p.Desempilhar()); 
                        resultado = num2 / num1; 
                        p.Empilhar(Double.toString((double) resultado));
                    }catch(Exception e){
                        System.out.println("Erro na montagem da expressão");
                    }
                }
                
                else if("^".equals(valida)){
                    try{
                        num1 = Double.parseDouble(p.Desempilhar()); 
                        num2 = Double.parseDouble(p.Desempilhar()); 
                        resultado = Math.pow(num2, num1);  
                        p.Empilhar(Double.toString((double) resultado));
                    }catch(Exception e){
                        System.out.println("Erro na montagem da expressão");
                    }
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(Expressao.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
    }
   
    public String MostraFila(){
        System.out.println("Pósfixa: " + fila);
        return fila.Imprime();
    }
    
    public String MostraPilha(){
        try{
        resultado = Double.parseDouble(p.Desempilhar());
        System.out.println("resltado: " +  df.format(resultado));
        }catch(Exception e){
        System.out.println("");
        }
        return df.format(resultado);
        
    }
    
    
    public void MostraExpressao(){
        System.out.println("expressao: " + expressao);
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    
    
}

package notaçãopolenesareversa;
/**
 *
 * @author Lucas Bergamin Dos Santos
 */

public class Pilha {
    String vetor[];
    int topo;
    
    
    public Pilha() {
        this(1000);
        topo = -1;
    }
    
    public Pilha(int qts){
        vetor = new String[qts];
        topo--;
    }
    
    
    
    public void Empilhar(String numero){
        vetor[++topo] = numero;
       
    }
    
    public String Desempilhar(){
        if(topo == -1)
            return "F";
        return vetor[topo--];
    }
    
    public String ConsultarTopo(){
        if(topo == -1)
            return "F";
        return vetor[topo];
    }
    
    public boolean Vazio(){
        return (topo == -1);
    }
    
    public boolean Cheio(){
        return (vetor.length == ( topo+1 ));
    }
    
    public String Imprime(){
    String retorno = "";
        if(topo == -1)
            return "Pilha vazia";
        for(int i = 0;i<=topo;i++)
            retorno += vetor[i] + " ";
        return retorno;
    }
    
    @Override
    public String toString(){
        String retorno = "";
        if(topo == -1)
            return "Pilha vazia";
        for(int i = 0;i<=topo;i++)
            retorno += vetor[i] + " ";
        return retorno;
    }
}

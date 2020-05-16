package notaçãopolenesareversa;
/**
 *
 * @author lucas Bergamin
 */
public class Fila {
    private String F[];
    private int inicio, fim;
    
    public Fila(int qtos){
        if(qtos<1) qtos = 10;
        F = new String[qtos];
        inicio = fim = -1;
    }
    
    public Fila(){
        this(1000);
    }
    
    public void enfileirar(String E)throws Exception{
        if(filaCheia()) 
            throw new Exception("Fila cheia");
        if(E.isEmpty()){
            
        }else
        {
            if(inicio == -1)
                inicio = 0;
            fim = (fim + 1) % F.length;
            F[fim] = E;
        }
    }
    
    public String desenfileirar()throws Exception{
        if(filaVazia()) 
            throw new Exception("Fila Vazia");
        String aux = F[inicio];
        F[inicio] = null;
        inicio = (inicio + 1)%F.length;
        if((inicio>fim) ||(inicio == 0) && (fim ==(F.length-1)))
           inicio=fim=-1;
        return aux;
    }
    
    public String consultarPrimeiro()throws Exception{
        if(filaVazia())
            throw new Exception("Fila Vazia");
        
        return F[inicio];
    }
    public boolean filaCheia(){
        return((inicio ==(fim+1)) || ((fim-inicio)==(F.length)));
    }
    public boolean filaVazia(){
        return (inicio == -1);
    }
    
    public String Imprime(){
    if(filaVazia()){
            return "fila vazia";
        }
        String retorno = "";
        for(int i = inicio;i<=fim;i++){
            retorno += F[i] + " ";
        }
        return retorno;
    }
    
    @Override
    public String toString(){
        if(filaVazia()){
            return "fila vazia";
        }
        String retorno = "";
        for(int i = inicio;i<=fim;i++){
            retorno += F[i] + " ";
        }
        return retorno;
    }
}

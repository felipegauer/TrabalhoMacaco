
public class Macaco {
    private int id;
    private int par;
    private int impar;
    private int cocosPar;
    private int cocosImpar;
   

    public Macaco(int id, int par, int impar) {
        this.id = id;
        this.par = par;
        this.impar = impar;
    }

    public int getId() {
        return id;
    }
    
    public int getPar() {
        return par;
    }

    public int getImpar() {
        return impar;
    }

    public int getCocosPar() {
        return cocosPar;
    }

    public int getCocosImpar() {
        return cocosImpar;
    }

   

    public void addCocosPar(int cocos) {
        this.cocosPar += cocos;
    }

    public void addCocosImpar(int cocos) {
        this.cocosImpar += cocos;
    }

    public int zeraCocosPar(){
        int aux = this.cocosPar;
        this.cocosPar = 0;
        return aux;
    }

    public int zeraCocosImpar(){
        int aux = this.cocosImpar;
        this.cocosImpar = 0;
        return aux;
    }

    
    
    
}
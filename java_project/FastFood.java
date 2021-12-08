import java.util.ArrayList;

public class FastFood{
    private static int quant_comm;
    private Stock stock;
    private ArrayList<Commande> commandes;

    public FastFood(Stock stock){
        this.stock = stock;
        this.commandes = new ArrayList<Commande>();
        quant_comm = (int)(Math.random()*(21))+0;
    }

    public void ajouterCommande(Commande c){

    }

    public boolean incendie(){
        int inc = (int)(Math.random()*(21))+0;

        if (inc >= 1){
            return true;
        }
        return false;
    }
}
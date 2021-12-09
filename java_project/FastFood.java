import java.util.ArrayList;

public class FastFood{
    private static int quant_comm;
    private Stock stock;
    private ArrayList<Commande> commande;

    public FastFood(Stock stock){
        this.stock = stock;
        this.commande = new ArrayList<Commande>();
        quant_comm = (int)(Math.random()*(21))+0;
    }

    public void ajouterCommande(Commande c){
        commande.add(c);
    }

    public boolean incendie(){
        int inc = (int)(Math.random()*(21))+0;

        if (inc == 1){
            return true;
        }
        return false;
    }

    public static int getQuantite(){
        return FastFood.quant_comm;
    }
}
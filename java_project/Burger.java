import java.util.ArrayList;

public class Burger{
    private static double prix = 0;
    private static double poids = 0;
    private ArrayList<Ingredient> composition;
    private final int MAX_QUANTITE = 100;
    private static int quantite = 0;

    public Burger(){
        this.composition = new ArrayList<Ingredient>();
    }

    public void ajouter_ingredient(Ingredient ing){
        if (Burger.quantite < MAX_QUANTITE){
            this.composition.add(ing);
            Burger.quantite++;
            Burger.prix+=ing.getPrix();
            Burger.poids+=ing.getPoids();
        }
    }

    public String toString(){
        String s = "";
        for (Ingredient i : composition){
            s += i.getNom()+" ";
        }
        return s;
    }

    public double getPrix(){
        return Burger.prix;
    }

    public double getPoids(){
        return Burger.poids;
    }

    public Burger clone(){
        Burger b2 = new Burger();
        for (Ingredient ing : composition){
            b2.composition.add(ing.clone());
        }
        return b2;
    }
}
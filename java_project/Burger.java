import java.util.ArrayList;

public class Burger{
    private double prix = 0;
    private double poids = 0;
    private ArrayList<Ingredient> composition;
    private final int MAX_QUANTITE = 100;
    private int quantite = 0;

    public Burger(){
        this.composition = new ArrayList<Ingredient>();
        this.prix = 0;
        this.poids = 0;
    }

    public void ajouterIngredient(Ingredient ing){
        if (this.quantite < MAX_QUANTITE){
            this.composition.add(ing);
            this.quantite++;
            this.prix+=ing.getPrix();
            this.poids+=ing.getPoids();
        }
    }

    public void retirerIngredient(){
        if (this.quantite > 0){
            Ingredient mying = this.composition.get(this.composition.size()-1);
            this.quantite--;
            this.prix-=mying.getPrix();
            this.poids-=mying.getPoids();
            this.composition.remove(mying);
        }
    }

    public String toString(){
        String s = "";
        for (Ingredient i : composition){
            if (i.getNom() != "NONE") s += i.getNom()+" ";   
        }
        return s;
    }

    public double getPrix(){
        return this.prix;
    }

    public double getPoids(){
        return this.poids;
    }

    public Burger clone(){
        Burger b2 = new Burger();
        for (Ingredient ing : composition){
            b2.composition.add(ing.clone());
        }
        b2.prix = this.prix;
        return b2;
    }
}
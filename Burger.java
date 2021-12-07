public class Burger{
    private static double prix = 0;
    private static double poids = 0;
    private Ingredient [] composition;
    private final int MAX_QUANTITE = 100;
    private static int quantite = 0;

    public Burger(){
        this.composition = new Ingredient[MAX_QUANTITE];
    }

    public void ajouter_ingredient(Ingredient ing){
        if (this.quantite < MAX_QUANTITE){
            this.composition[quantite] = ing;
            this.quantite++;
            this.prix+=ing.getPrix();
            this.poids+=ing.getPoids();
        }
    }

    public double getPrix(){
        return this.prix;
    }

    public double getPoids(){
        return this.poids;
    }

    public Burger clone(){
        Burger b2 = new Burger();
        b2.composition = new Ingredient[MAX_QUANTITE];
        for (int i = 0;i<quantite;i++){
            b2.composition[i] = this.composition[i].clone();
        }
        return b2;
    }
}
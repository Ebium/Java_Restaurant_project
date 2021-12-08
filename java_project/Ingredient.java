public class Ingredient implements Promotion{
    private String nom;
    private final double poids;
    private double prix;
    public String [] list_ingredient = new String[]{"Tomate","Salade","Oignon","Fromage","Beacon","Steak","Sauce","Pain"};



    public Ingredient(String nom, double poids, double prix){
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public double getPrix(){
        return this.prix;
    }

    public double getPoids(){
        return this.poids;
    }

    public Ingredient clone(){
        return new Ingredient(this.nom,this.poids,this.prix);
    }

    public void avoirPromotion(int prom){
        this.prix =((this.prix * prom)/100);
    }

    public String[] getString(){
        return list_ingredient;
    }
}
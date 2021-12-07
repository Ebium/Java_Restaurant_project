public class Dessert{
    protected final double prix;
    protected String nom;

    public Dessert(double prix, String nom){
        this.prix = prix;
        this.nom = nom;
    }

    public double getPrix(){
        return this.prix;
    }
}
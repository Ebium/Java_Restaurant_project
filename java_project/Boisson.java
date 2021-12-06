public class Boisson{
    protected final double prix;
    protected String nom;
    protected int quantite;

    public Boisson(double prix, String nom,int quantite){
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public double getPrix(){
        return this.prix;
    }

    public String toString(){
        return ""+nom+" de "+quantite+" cl, "+prix;
    }
}
public class Boisson{
    protected final double prix;
    protected String nom;
    protected int quantite;
    private static String [] liste_boisson = new String[]{"Jus","Eau","Coca"};

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

    public String getNom(){
        return this.nom;
    }

    public static String[] getListeBoisson(){
        return liste_boisson;
    }
}
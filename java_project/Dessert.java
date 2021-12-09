public class Dessert{
    protected final double prix;
    protected String nom;
    private static String [] liste_dessert = new String[]{"Donut","Brownie","Cookie"};

    public Dessert(double prix, String nom){
        this.prix = prix;
        this.nom = nom;
    }

    public double getPrix(){
        return this.prix;
    }

    public String getNom() {
        return this.nom;
    }

    public static String[] getListeDessert(){
        return liste_dessert;
    }

    public String toString(){
        String s = "";
        if (this.nom != "NONE") s = this.nom;
        return s;
    }
}
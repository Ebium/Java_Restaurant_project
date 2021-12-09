import java.util.ArrayList;

public class Commande implements Promotion{
    private final int id;
    private static int cpt_id = FastFood.getQuantite();
    private ArrayList<Burger> burger;
    private ArrayList<Boisson> boisson;
    private ArrayList<Dessert> dessert;
    private static double prix = 0;

    public Commande(){
        cpt_id++;
        this.id = cpt_id;
        this.burger = new ArrayList<Burger>();
        this.dessert = new ArrayList<Dessert>();
        this.boisson = new ArrayList<Boisson>();
        prix = 0;
    }

    public void avoirPromotion(int prom){
        Commande.prix = Commande.prix -((Commande.prix * prom)/100);
    }

    public void ajoutBurger(Burger bur){
        this.burger.add(bur);
        Commande.prix += bur.getPrix();
    }

    public void ajoutBoisson(Boisson boi){
        this.boisson.add(boi);
        Commande.prix += boi.getPrix();
    }

    public void ajoutDessert(Dessert des){
        this.dessert.add(des);
        Commande.prix += des.getPrix();
    }

    public int getId(){
        return this.id;
    }

    public double getPrix(){
        return Commande.prix;
    }

    public void setPrix(double p){
        Commande.prix += p;
    }

    public String toString(){
        String s = "Burger(s) : ";
        for (Burger b: burger) if (b.toString() != "") s += b.toString()+"| ";
        s+="\n Dessert(s) : ";
        for (Dessert d: dessert) if (d.toString() != "") s+= d.toString()+" | ";
        s+="\n Boisson(s) : ";
        for (Boisson bo: boisson) if (bo.toString() != "") s+= bo.toString()+" | ";
        return s;
    }
}
import java.util.ArrayList;

public class Commande implements Promotion{
    private final int id;
    private static int cpt_id = 0;
    private ArrayList<Burger> burger;
    private ArrayList<Boisson> boisson;
    private ArrayList<Dessert> dessert;
    private static double prix;

    public Commande(){
        cpt_id++;
        this.id = cpt_id;
        this.burger = new ArrayList<Burger>();
        this.dessert = new ArrayList<Dessert>();
        this.boisson = new ArrayList<Boisson>();
    }

    public void avoirPromotion(int prom){
        this.prix =((this.prix * prom)/100);
    }

    public void ajoutBurger(Burger bur){
        this.burger.add(bur);
        this.prix += bur.getPrix();
    }

    public void ajoutBoisson(Boisson boi){
        this.boisson.add(boi);
        this.prix += boi.getPrix();
    }

    public void ajoutDessert(Dessert des){
        this.dessert.add(des);
        this.prix += des.getPrix();
    }
}
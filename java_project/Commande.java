import java.util.ArrayList;

public class Commande implements Promotion{
    private final int id;
    private static int cpt_id = FastFood.getQuantite();
    private ArrayList<Burger> burger;
    private ArrayList<Boisson> boisson;
    private ArrayList<Dessert> dessert;
    private double prix = 0;

    public Commande(){
        cpt_id++;
        this.id = cpt_id;
        this.burger = new ArrayList<Burger>();
        this.dessert = new ArrayList<Dessert>();
        this.boisson = new ArrayList<Boisson>();
        prix = 0;
    }

    public void avoirPromotion(int prom){
        this.prix = this.prix -((this.prix * prom)/100);
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

    public int getId(){
        return this.id;
    }

    public double getPrix(){
        return this.prix;
    }

    public void setPrix(double p){
        this.prix += p;
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

    public void cloneBurger(){
        if (burger.size() > 0) {
        Burger newburger = new Burger();
        newburger = burger.get(burger.size() - 1).clone();
        ajoutBurger(newburger);
        }
        else{
            MyUtils.clear();
            System.out.println("Vous n'avez pas encore ajouté de burger !\n");
            MyUtils.line();
            MyUtils.wait(2000);
        } 

    }
}
public class Commande implements Promotion{
    private final int id;
    private static int cpt_id = 0;
    private Boisson [] boisson;
    private Burger [] burger;
    private Dessert [] dessert;
    private double prix;

    public Commande(Boisson boisson, Burger burger, Dessert dessert){
        cpt_id++;
        this.id = cpt_id;
        for (Burger b:this.burger) prix += b.getPrix();
        for (Boisson bo:this.boisson) prix += bo.getPrix();
        for (Dessert d:this.dessert) prix += d.getPrix();
    }


    public void avoirPromotion(int prom){
        this.prix =((this.prix * prom)/100);
    }
}
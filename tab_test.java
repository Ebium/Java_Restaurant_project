public class HelloWorld{

     public static void main(String []args){
         
         String[][] tab = {{"|", "-", "-", "-", "-", "-", "-", "-","|"}, 
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", " ", " ", " ", " ", " ", " ", " ","|"},
                           {"|", "-", "-", "-", "-", "-", "-", "-","|"}};
                           
         String[][] tab2 = new String[20][30];
         String t;
         
        for (int s = 0;s<tab2.length;s++){
            for (int j = 0;j<tab2.length;j++) {
                if((s==0)||(s==19)) t = "-";
                else t = " ";
                if((j==0)||(j==19)) t = "|";
                tab2[s][j] = t;
            }
        } 
        
        
        for (int s = 0;s<tab2.length;s++){
            for (int j = 0;j<tab2.length;j++) System.out.print(tab2[s][j]);
           System.out.println("");
        }
     }
}

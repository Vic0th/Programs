/*  Ortalama değeri λ olarak alalım. O halde;
    
    f(X) = { λ*(e^(-λ*t)) , X > 0 ve diğer durumlarda 0 olarak kabul edilir.
 
    Beklenen Değer 1/λ ve Varyans (1/λ)^2 olarak hesaplanır.
*/
package project_ps.omer;

import java.util.Scanner;

public class UstelDagilim {
    
    static final double E = 2.71;
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Ortalama Değeri Giriniz: ");    
        double od = scan.nextDouble();//ortalama değeri λ
        System.out.print("Maximum Değeri Giriniz: ");  //max sonsuza gidiyorsa ~ ifadesini girin  
        int ust_sinir = scan.nextInt();
        System.out.print("Minimum Değeri Giriniz: ");    
        int alt_sinir = scan.nextInt();
        
        double bd;//beklenen değer
        bd= 1/ od;
        double vry;//varyans
        vry=Math.pow(1/od,2);
        
        
        System.out.println("Sonuç: " + UstHesapla(od,ust_sinir,alt_sinir));
        System.out.println("Beklenen Değer: " +bd);
        System.out.println("Varyans: " +vry);
    }
    public static double UstHesapla(double a,int b,int c){
        double sonuc;
        if( b > 0)
        {
            if(c==0 && b> 0)
             sonuc = 1 - Math.pow(E,(-(a*b)) );
            else sonuc=0.0;
         }
        else if(b==-1 && c>0)//sonsuzu ifade etmek için kullanıcı ~-1 ifadesini girsin 
                sonuc = Math.pow(E,(-(a*c)));
        else sonuc=0.0;
        
        return sonuc;
        }
}

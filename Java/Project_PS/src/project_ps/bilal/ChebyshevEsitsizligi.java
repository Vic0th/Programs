
package chebyshevesitsizligi;

import java.util.Scanner;

public class ChebyshevEsitsizligi {

   public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Ortalamayı Giriniz: ");    
        double ort = input.nextDouble();
        
        System.out.print("Standart Sapmayı Giriniz: ");    
        double stdS = input.nextDouble();
        
        System.out.print("Maksimum veya Minimum Aralığı Giriniz: ");
        double aralik = input.nextDouble();
        
        if(aralik>ort){
            double max_deger = aralik;
        }
        else{
            double min_deger = aralik;
        }
        double max_deger=aralik;
        double min_deger = aralik;
        //double maxort_fark;
        //maxort_fark = max_deger-ort;
        
        if(max_deger==aralik){
           
           double k = (max_deger-ort)/stdS;
           double sonuc = 1-(1/Math.pow(k, 2));
           System.out.println("Sonuç: " +sonuc);
        }
        else if(min_deger==aralik) {
            double k = (min_deger-ort)/stdS;
            double sonuc = 1-(1/Math.pow(k, 2));
            System.out.println("Sonuç: " +sonuc);
        }
        
        
        
        
    }
    
}

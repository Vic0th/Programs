
package project_ps.omer;

import java.util.Scanner;


public class GeometrikDagilim {

    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Başarı Olasılığı Değerini Giriniz: ");
        double p = scan.nextDouble();//p = Başarı olasılığı
        System.out.print("Deneme Sayısını Giriniz: ");
        double X = scan.nextDouble();//X = İlk başarı elde edilene kadar yapılan deneme sayısı
        System.out.println("Olasılık Değeri: " +GeoHesapla(p,X));
        System.out.println("Beklenen Değer: "+ (1/p));
        System.out.println("Varyans: "+ ((1-p)/(p*p)));
    }
    public static double GeoHesapla(double a,double b){
        double deger=a * Math.pow(1-a, b-1);
        return deger;
        }
}

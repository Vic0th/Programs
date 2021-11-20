/*
Kesikli Rastgele Değişkenin Beklenen Değeri ve Varyans Hesabı
 */
package beklenendeger_varyans;

import java.util.Scanner;

public class BeklenenDeger_Varyans {

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Ortalamayı Giriniz: ");    
        double ort = input.nextDouble();
        
        double beklD;
        beklD = 1/ort;
        
        double varyans;
        varyans = Math.pow(1/ort,2);
        
        System.out.println("Beklenen Değer: " +beklD);
        System.out.println("Varyans: " +varyans);
    }
    
}

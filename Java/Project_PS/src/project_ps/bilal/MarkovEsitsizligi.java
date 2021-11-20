
package markovesitsizligi;

import java.util.Scanner;

public class MarkovEsitsizligi {
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Ortalamayı Giriniz: ");    
        double ort = input.nextDouble();
        
        System.out.print("Minimum Değeri Giriniz: "); 
        int min_deger = input.nextInt();
        
        double markov;
        markov = ort/min_deger;
        
        System.out.println("Sonuç: " +markov);
        
    }
    
}

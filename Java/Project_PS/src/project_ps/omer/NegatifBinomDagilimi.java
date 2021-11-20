
package project_ps.omer;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class NegatifBinomDagilimi {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaçıncı Deneyde Başarı Elde Edileceğini Girin: ");
        int X = scan.nextInt();
        System.out.print("Elde Edilen Başarı Sayısını Girin: ");
        int K = scan.nextInt();
        System.out.print("Başarı Olasılığını Girin: ");
        double p = scan.nextDouble();
        System.out.println("Olasılık Değeri: " +NegBinHesapla(X,K,p));
        System.out.println("Beklenen Değer: " +(K/p));
        System.out.println("Varyans: " +(K*(1-p)/(p*p)));
    }
    public static long factorial(int x){
        long t = 1;
        if(x < 1)
            return 0;
        else if(x == 1)
            return 1;
        else{
            for(int y=1; y <= x; y++)
                t *= y;
            return t;
        }
    }
    public static long combination(int x, int y){
        if(x < y || x < 1 || y < 1){
            JOptionPane.showMessageDialog(null,"Geçersiz sayı girişi."
                    + " 2 sayı da pozitif tam sayı olmalı ve 1. tamsayı 2. tamsayıdan büyük veya eşit olmalıdır.");
            return 0;
        }
        else if(x == y)
            return 1;
        if(x - y > y){
            long t = 1;
            for(int i = x; i > x - y; i--)
                t *= i;
            return t / factorial(y);
        }
        else{
            long t = 1;
            for(int i = x; i > y; i--)
                t *= i;
            return t / factorial(x-y);
        }
    }
    public static double NegBinHesapla(int a,int b,double c){
        double deger=combination(a-1,b-1)*Math.pow(c, b)*Math.pow(1-c, a-b);
        return deger;
        }
}
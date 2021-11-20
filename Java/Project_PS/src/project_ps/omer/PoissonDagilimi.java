
package project_ps.omer;

import java.util.Scanner;


public class PoissonDagilimi {

    static final double E = 2.71;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Dağılım Ortalamasını Giriniz: ");
        double ld = scan.nextDouble();
        System.out.print("Olay Sayısını Giriniz: ");
        int X = scan.nextInt();
        System.out.println("Olasılık Değeri: "+PoiHesapla(ld,X));
        System.out.println("Beklenen Değer: "+ld);
        System.out.println("Varyans: "+ld);
    }
    public static int fakt(int s) {
		int sonuc=1;
		for(int i=1;i<=s;i++) {
			sonuc*=i;
		}
		return sonuc;
	}
    public static double PoiHesapla(double a,int b){
        double deger=Math.pow(E, (-a))*Math.pow(a, b)/fakt(b);
        return deger;
        }
}

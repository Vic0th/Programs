package project_ps.omer;

import java.util.Scanner;

public class BinomDagilimi {
      public static void main(String[] args) {
        
   	 Scanner scan = new Scanner(System.in);
         System.out.print("Deneme Sayısını Giriniz: ");
	 int n = scan.nextInt();//n= Bernoulli Denemesi
         System.out.print("Başarı Olasılığı Değerini Giriniz: ");
         double p = scan.nextDouble();//p = BAşarı olasılığı
	 System.out.print("Başarılı Olan Deneme Sayısını Giriniz: ");	
	 int X = scan.nextInt();
	 System.out.println("Olasılık Değeri: "+BinomHesapla(n,X,p));
         System.out.println("Beklenen Değer: "+ (n*p));
         System.out.println("Varyans: " + (n*p*(1-p)));
 }
	public static int fakt(int s) {
		int sonuc=1;
		for(int i=1;i<=s;i++) {
			sonuc*=i;
		}
		return sonuc;
	}
	public static int kombinasyon(int c, int r) {
		if(c>0 && r>0 && c >= r) {
		return (fakt(c)/(fakt(c-r)*fakt(r)));
		}
		else return 0;
	}
        public static double BinomHesapla(int a,int b, double c){
            double deger=kombinasyon(a,b)*Math.pow(c, b)*Math.pow(1-c, a-b);
        return deger;
        }
}
    

     








public class CikisIslemleri implements CikisIslemlerInterface {
    // Cikis İslemleri Class'ı CikisIslemlerInterface'ini implement etmektedir.
    // bu yüzden interface'deki abstract method'ları override etmek zorundadır.

    @Override
    public void urunCikis() {
        Methods.urunListele();
        System.out.print("Cıkısını yapmak istediginiz ürün id bilgisini girin : ");
        int urunId;
        try {
            urunId = Methods.scan.nextInt();
            Methods.scan.nextLine();
            if (Methods.urunListesi.containsKey(urunId)) {
                Urun secilenUrun = Methods.getUrunById(urunId);
                System.out.print("Kaç adet cıkıs yapmak istersiniz : ");
                int miktar = 0;
                try {
                    miktar = Methods.scan.nextInt();
                    Methods.scan.nextLine();
                } catch (Exception e) {
                    Methods.scan.nextLine();
                    System.out.println("Hatalı veri girdiniz");
                }
                if (secilenUrun.getMiktar() >= miktar) {
                    int yeniMiktar = secilenUrun.getMiktar() - miktar;
                    secilenUrun.setMiktar(yeniMiktar);
                    System.out.println("Cıkıs islemi basarıyla gerceklesti");
                    System.out.println("Menu için lütfen bekleyiniz..");
                    Thread.sleep(3000);// Console'da belli bir süre bekletmesi için
                    new Methods().urunListele();
                } else {
                    System.out.println("Girdiginiz miktar stoklarımızı aşıyor");
                }
            } else {
                System.out.println("Böyle bir ürün yok");
            }
        } catch (Exception e) {
            Methods.scan.nextLine();
            System.out.println("Hatalı veri girdiniz");
        }
    }
}
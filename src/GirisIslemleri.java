public class GirisIslemleri implements GirisIslemlerInterface {
    //Giris İslemleri Class'ı GirisIslemlerInterface'ini implement etmektedir.
    // bu yüzden interface'deki abstract method'ları override etmek zorundadır.

    static int idCount = 1000;

    @Override
    public void urunTanimla() throws InterruptedException {
        System.out.print("\nÜrün ismini girin : ");
        String urunIsmi = Methods.scan.nextLine().toUpperCase();
        System.out.print("Üretici bilgisini girin : ");
        String uretici = Methods.scan.nextLine().toUpperCase();
        System.out.print("Birim bilgisini girin : ");
        String birim = Methods.scan.nextLine().toUpperCase();
        Urun urun = new Urun(++idCount, urunIsmi, uretici, birim);
        Methods.urunListesi.put(urun.getId(), urun);
        System.out.println("Ürün kaydı tamamlandı.. Menu için Bekleyiniz..");
        Thread.sleep(3000);
        Methods.urunListele();
    }

    public void urunGiris() {
        Methods.urunListele();
        System.out.print("Id girin : ");
        int id;
        try {
            id = Methods.scan.nextInt();
            Methods.scan.nextLine();
            if (Methods.urunListesi.containsKey(id)) {
                Urun secilenUrun = Methods.getUrunById(id);
                System.out.print("Yeni adet bilgisini girin : ");
                int adet;
                try {
                    adet = Methods.scan.nextInt();
                    Methods.scan.nextLine();
                    if (adet <= 0) {
                        System.out.println("Hatalı veri girdiniz");
                    } else {
                        secilenUrun.setMiktar(adet);
                        System.out.println("Yeni adet bilgisi başarıyla kaydedildi.. Menu için bekleyiniz...");
                        Thread.sleep(5000); // Console'da belli bir süre bekletmesi için
                        Methods.urunListele();
                    }
                } catch (Exception e) {
                    System.out.println("Hatalı veri girdiniz");
                }
            } else {
                System.out.println("Böyle bir ürün yok");
            }
        } catch (Exception e) {
            Methods.scan.nextLine();
            System.out.println("Hatalı giriş yaptınız");
        }
    }

    @Override
    public void rafOlustur() throws InterruptedException {
        int max = 0;
        for (int i : Methods.rafListesi) {
            if (i > max) max = i;
        }
        Methods.rafListesi.add(++max);
        System.out.println((max) + " numaralı rafınız oluşturuldu");
        System.out.println("Menu için lütfen bekleyiniz...");
        Thread.sleep(3000);
    }

    @Override
    public void urunuRafaKoy() {
        Methods.urunListele();
        System.out.print("Rafa yerlestirmek istediginiz ürün id bilgisini girin : ");
        int urunId;
        try {
            urunId = Methods.scan.nextInt();
            Methods.scan.nextLine();
            if (Methods.urunListesi.containsKey(urunId)) {
                Urun secilenUrun = Methods.getUrunById(urunId);
                System.out.println("Seçebileceginiz raflar\n");
                for (Integer raf : Methods.rafListesi) {
                    System.out.print(" < " + raf + " > ");
                }
                System.out.print("\nHangi rafa yerleştirmek istersiniz : ");
                int rafId;
                try {
                    rafId = Methods.scan.nextInt();
                    Methods.scan.nextLine();
                    if (Methods.rafListesi.contains(rafId)) {
                        if (secilenUrun.getRaf() != rafId) {
                            secilenUrun.setRaf(rafId);
                            System.out.println("Rafa yerleştirme başarıyla tamamlandı");
                            System.out.println("Menu için lütfen bekleyiniz...");
                            Thread.sleep(3000);// Console'da belli bir süre bekletmesi için
                            new Methods().urunListele();
                        } else {
                            System.out.println("Sectiginiz ürün zaten bu rafta bulunuyor");
                        }
                    } else {
                        System.out.println("Böyle bir raf bulunmuyor");
                    }
                } catch (Exception e) {
                    Methods.scan.nextLine();
                    System.out.println("Hatalı veri girdiniz");
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

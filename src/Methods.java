import java.util.*;
public class Methods {
    static Scanner scan = new Scanner(System.in);
    static Map<Integer, Urun> urunListesi = new HashMap<>();
    static Set<Integer> rafListesi = new HashSet<>(Arrays.asList(1, 2, 3));

    public static void hosgeldinEkrani() throws InterruptedException {
        System.out.println();
        System.out.printf("%50s", "*******************\n");
        System.out.printf("%33s %10s %-33s", "***", "HOSGELDİNİZ", "***\n");
        System.out.printf("%22s", "*******************\n\n");
        girisEkrani();
    }
    public static void girisEkrani() throws InterruptedException {
        System.out.printf("%-20s %-20s %-17s %-21s %-17s %-24s %-20s", "Ürün tanımlama : 1",
                "Ürün listeleme : 2", "Ürün girişi : 3", "Ürün rafa koyma : 4\n", "Ürün çıkışı : 5",
                "Yeni raf oluşturma : 6", "İşlemi bitirme : 7");
        System.out.print("\n\nLütfen yapmak istediğiniz işlemi seçin : ");
        String secim = scan.nextLine();
        switch (secim) {
            case "1":
                new GirisIslemleri().urunTanimla();
                break;
            case "2":
                urunListele();
                break;
            case "3":
                new GirisIslemleri().urunGiris();
                break;
            case "4":
                new GirisIslemleri().urunuRafaKoy();
                break;
            case "5":
                new CikisIslemleri().urunCikis();
                break;
            case "6":
                new GirisIslemleri().rafOlustur();
                break;
            case "7":
                bitir();
                break;
            default:
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyin");
                break;
        }
        girisEkrani();
    }

    static void urunListele() {
        System.out.println();
        System.out.printf("%-7s %-14s %-25s %-15s %-14s %-5s\n", "Id", " İsim", " Üretici", " Miktar", "Birim", "Raf");
        System.out.println("------------------------------------------------------------------------------------");
        Collection<Urun> valueCol = urunListesi.values();
        List<Urun> urunList = new ArrayList<>();
        urunList.addAll(valueCol);
        for (Urun u : urunList) {
            System.out.printf("%-8d %-14s %-25s %-14s %-14s %-5d", u.getId(), u.getUrunIsmi(), u.getUretici(), u.getMiktar(), u.getBirim(), u.getRaf());
            System.out.println();
        }
        System.out.println();
    }

    private static void bitir() {
        System.out.printf("\n%33s %10s %-33s\n", "***", "YİNE BEKLERİZ", "***");
        System.exit(0);
    }

    static Urun getUrunById(int id) {
        return urunListesi.getOrDefault(id, new Urun());
    }
}
import java.util.Scanner;

public class proje {

    static Scanner input = new Scanner(System.in);

    static String[] anaMenu = {
            "Proteinler","Spor Gıdaları","Vitaminler",
            "Sağlık","Gıda","Aksesuar"
    };

    static String[][] altMenuler = {
            {"Whey Protein", "Whey İzole", "Kazein", "Bitkisel"},
            {"Amino Asitler", "Pre-Workout", "Karbonhidratlar"},
            {"Vitaminler", "Mineraller", "Özel Formül Ürünler"},
            {"Fonksiyonel Gıdalar", "Bitki Tozları", "Zayıflama"},
            {"Gıda Ürünleri"},
            {"Çantalar", "Shakerlar", "Wrist Wraps", "Lifting Straps",
             "Termal Korse", "Pillbox Ve Huni", "Havlu"}
    };

    static String[][][] urunler = {
            {
                {"Supplementler.com Whey", "Scitec Whey", "Hardline Whey 3 Matrix", "Weider Premium Whey", "Proteinocean Whey", "Optimum Whey"},
                {"Supplementler.com Isolate", "Scitec Isolate", "Hardline IsoWhey", "Proteinocean Whey Isolate"},
                {"Supplementler.com Casein", "Optimum Gold Standart Caseine", "Hardline Casein Matrix", "Proeinocean Mılk Protein"},
                {"Hardline Vmax Protein","Optimum Gold Plant", "Proteinocean PEA Protein"}
            },
            {
                {"Weider Amino Tablet", "Supplementler.com Arginine","Kingsize Nutrition Loaded Ultra Amino"},
                {"Proteinocn Supreme PRE", "Proteinocn HEAVY DUTY PRE","Bigjoy Predator"},
                {"Hardline Pro Gainer", "Supplementler.com Gainer","Bigjoy Big Mass +GH Factors","Proteinocn Mass Gaıner"}
            },
            {
                {"Omega3", "D3", "Multivitamin", "ZMA", "Magnesium", "Ester-C","Caffeine","B12"},
                {"Selenıum","Chromıum","Magnesıum Complex","Iron"},
                {"Flava Thermo Burner","Flava LVR","Flava KDNY", "Flava Green Detox"}
            },
            {
                {"Collagen","Protein Meal","Prebıo Tıcs","Flavor Powder","Sweetener","Protein Coffee"},
                {"Greens & Superfoods","Green Detox+","Maca Root Powder","Red Detox+"},
                {"L-Carnitine","Cla+","Hunger Buster"}
            },
            {
                {"Cream Of Rice Chocolate", "Protein Bar", "Düşük Kalori Ketçap","Hindistan Cevizi Yağı"}
            },
            {
                {"Relentless Gym Handbag", "Dechatlon Spor Çantası"},
                {"Superman Shaker","Batman Shaker","Relentless Shaker","Proteinocn Shaker"},
                {"Wrist Wraps","Batman Wrist Wraps","Superman Wrist Wraps"},
                {"Lifting Straps"},
                {"Termal Korse"},
                {"PillBox","Proteinocean Huni"},
                {"Proteinocean Havlu","Supplementler.com Havlu"}
            }
    };

    static int[][][] stoklar = {
            { {10,5,3,5,6,8}, {8,6,10,20}, {4,6,8,15}, {3,6,23} },
            { {7,5,6}, {6,4,6}, {9,4,6,8} },
            { {10,19,24,50,38,15,38,45}, {5,65,24,56}, {3,5,8,12} },
            { {6,6,9,15,5,23}, {8,12,24,18}, {4,6,12} },
            { {12,6,34,28} },
            { {5,3}, {10,12,24,32}, {7,4,8}, {6}, {4}, {8,15}, {9,12} }
    };

    static double[][][] fiyatlar = {
            { {450,480,520,610,430,590}, {620,650,680,610}, {540,690,610,490}, {560,720,510} },
            { {320,280,350}, {410,460,430}, {520,480,610,590} },
            { {190,120,260,240,210,180,160,130}, {140,150,220,200}, {310,290,340,360} },
            { {260,310,280,190,150,330}, {240,270,310,290}, {220,250,260} },
            { {180,90,75,160} },
            { {650,480}, {120,140,160,130}, {210,230,250}, {190}, {280}, {90,60}, {150,170} }
    };

    static double toplamTutar = 0;
    static int toplamUrun = 0;

    static void faturaYaz(String urunAdi, int adet, double birimFiyat) {
        double araToplam = adet * birimFiyat;
        toplamTutar += araToplam;
        toplamUrun += adet;

        System.out.println("\n========== FATURA ==========");
        System.out.println("Ürün      : " + urunAdi);
        System.out.println("Adet      : " + adet);
        System.out.println("Birim F.  : " + birimFiyat + " TL");
        System.out.println("Ara Toplam: " + araToplam + " TL");
        System.out.println("----------------------------");
        System.out.println("Toplam Ürün: " + toplamUrun);
        System.out.println("GENEL TOPLAM: " + toplamTutar + " TL");
        System.out.println("============================\n");
    }

    static int anaMenuSec() {
        while (true) {
            System.out.println("\n******** Supplement Satış Sistemi ********");
            for (int i = 0; i < anaMenu.length; i++)
                System.out.println((i + 1) + ". " + anaMenu[i]);

            System.out.println("9. Ürün Ara");
            System.out.println("0. Çıkış");
            System.out.print("Seçim: ");
            int secim = input.nextInt();

            if (secim == 0) System.exit(0);

            if (secim == 9) {
                urunAra();
                continue;
            }

            if (secim >= 1 && secim <= anaMenu.length)
                return secim - 1;

            System.out.println("Hatalı seçim!");
        }
    }

    static void urunAra() {
        input.nextLine();
        System.out.print("\nAranacak ürün adı: ");
        String aranan = input.nextLine().toLowerCase();
        boolean bulundu = false;

        for (int i = 0; i < urunler.length; i++) {
            for (int j = 0; j < urunler[i].length; j++) {
                for (int k = 0; k < urunler[i][j].length; k++) {
                    if (urunler[i][j][k].toLowerCase().contains(aranan)) {
                        System.out.println("\n--- ÜRÜN BULUNDU ---");
                        System.out.println("Kategori    : " + anaMenu[i]);
                        System.out.println("Alt Kategori: " + altMenuler[i][j]);
                        System.out.println("Ürün        : " + urunler[i][j][k]);
                        System.out.println("Stok        : " + stoklar[i][j][k]);
                        System.out.println("Fiyat       : " + fiyatlar[i][j][k] + " TL");
                        bulundu = true;
                    }
                }
            }
        }

        if (!bulundu)
            System.out.println("Ürün bulunamadı!");
    }

    static void altMenu(int anaIndex) {
        while (true) {
            System.out.println("\n" + anaMenu[anaIndex]);
            for (int i = 0; i < altMenuler[anaIndex].length; i++)
                System.out.println((i + 1) + ". " + altMenuler[anaIndex][i]);
            System.out.println("0. Geri Dön");

            System.out.print("Seçim: ");
            int secim = input.nextInt();

            if (secim == 0) return;
            if (secim >= 1 && secim <= altMenuler[anaIndex].length)
                urunMenu(anaIndex, secim - 1);
        }
    }

    static void urunMenu(int ana, int alt) {
        while (true) {
            System.out.println("\nÜrünler:");
            for (int i = 0; i < urunler[ana][alt].length; i++) {
                System.out.println((i + 1) + ". " + urunler[ana][alt][i]
                        + " | Stok: " + stoklar[ana][alt][i]
                        + " | Fiyat: " + fiyatlar[ana][alt][i] + " TL");
            }
            System.out.println("0. Geri Dön");

            System.out.print("Seçim: ");
            int secim = input.nextInt();
            if (secim == 0) return;

            int index = secim - 1;

            System.out.print("Kaç adet almak istiyorsunuz?: ");
            int adet = input.nextInt();

            if (adet <= 0) {
                System.out.println("Geçersiz adet!");
                continue;
            }

            if (stoklar[ana][alt][index] >= adet) {
                stoklar[ana][alt][index] -= adet;
                faturaYaz(urunler[ana][alt][index], adet, fiyatlar[ana][alt][index]);
            } else {
                System.out.println("Yetersiz stok!");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            altMenu(anaMenuSec());
        }
    }
}
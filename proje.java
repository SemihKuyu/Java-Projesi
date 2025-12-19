import java.util.Scanner;

public class proje {

    static Scanner input = new Scanner(System.in); //Sürekli tanımlamamak için bu şekilde tanımladım

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

    //ürünler burda
    static String[][][] urunler = {
            {   // Proteinler burda
                {"Supplementler.com Whey", "Scitec Whey", "Hardline Whey 3 Matrix", "Weider Premium Whey", "Proteinocean Whey", "Optimum Whey"},
                {"Supplementler.com Isolate", "Scitec Isolate", "Hardline IsoWhey", "Proteinocean Whey Isolate"},
                {"Supplementler.com Casein", "Optimum Gold Standart Caseine", "Hardline Casein Matrix", "Proeinocean Mılk Protein"},
                {"Hardline Vmax Protein","Optimum Gold Plant", "Proteinocean PEA Protein"}
            },
            {   // Spor Gıdaları burda
                {"Weider Amino Tablet", "Supplementler.com Arginine","Kingsize Nutrition Loaded Ultra Amino"},
                {"Proteinocn Supreme PRE", "Proteinocn HEAVY DUTY PRE","Bigjoy Predator"},
                {"Hardline Pro Gainer", "Supplementler.com Gainer","Bigjoy Big Mass +GH Factors","Proteinocn Mass Gaıner"}
            },
            {   // Vitaminler burada
                {"Omega3", "D3", "Multivitamin", "ZMA", "Magnesium", "Ester-C","Caffeine","B12"},
                {"Selenıum","Chromıum","Magnesıum Complex","Iron"},
                {"Flava Thermo Burner","Flava LVR","Flava KDNY", "Flava Green Detox"}
            },
            {   // Sağlık ürünleri burda
                {"Collagen","Protein Meal","Prebıo Tıcs","Flavor Powder","Sweetener","Protein Coffee"},
                {"Greens & Superfoods","Green Detox+","Maca Root Powder","Red Detox+"},
                {"L-Carnitine","Cla+","Hunger Buster"}
            },
            {   // Gıdalar burda
                {"Cream Of Rice Chocolate", "Protein Bar", "Düşük Kalori Ketçap","Hindistan Cevizi Yağı"}
            },
            {   // Aksesuarlar burda
                {"Relentless Gym Handbag", "Dechatlon Spor Çantası"},
                {"Superman Shaker","Batman Shaker","Relentless Shaker","Proteinocn Shaker"},
                {"Wrist Wraps","Batman Wrist Wraps","Superman Wrist Wraps"},
                {"Lifting Straps"},
                {"Termal Korse"},
                {"PillBox","Proteinocean Huni"},
                {"Proteinocean Havlu","Supplementler.com Havlu"}
            }
    };

    //stoklar burda
    static int[][][] stoklar = {
            { {10,5,3,5,6,8,3}, {8,6,10,20}, {4,6,8,15}, {3,6,23} },
            { {7,5,6}, {6,4,6}, {9,4,6,8} },
            { {10,19,24,50,38,15,38,45}, {5,65,24,56}, {3,5,8,12} },
            { {6,6,9,15,5,23}, {8,12,24,18}, {4,6,12} },
            { {12,6,34,28} },
            { {5,3}, {10,12,24,32}, {7,4,8}, {6}, {4}, {8,15}, {9,12} }
    };

    static void hataMesaji() {
        System.out.println("Hatalı seçim! Tekrar deneyiniz.\n");
    }

    static int anaMenuSec() {
        int secim;
        while (true) {
            System.out.println("\n******** Supplement Satış Sistemi ********");
            for (int i = 0; i < anaMenu.length; i++)
                System.out.println((i + 1) + ". " + anaMenu[i]);

            System.out.print("Seçim: ");
            secim = input.nextInt();

            if (secim >= 1 && secim <= anaMenu.length)
                return secim - 1;

            hataMesaji();
        }
    }

    static void altMenu(int anaIndex) {
        int secim;

        while (true) {
            System.out.println("\n" + anaMenu[anaIndex]);
            System.out.println("----------------------------");

            for (int i = 0; i < altMenuler[anaIndex].length; i++)
                System.out.println((i + 1) + ". " + altMenuler[anaIndex][i]);

            System.out.println("0. Geri dön");
            System.out.print("Seçim: ");
            secim = input.nextInt();

            if (secim == 0) return;

            if (secim >= 1 && secim <= altMenuler[anaIndex].length)
                urunMenu(anaIndex, secim - 1);
            else
                hataMesaji();
        }
    }

    static void urunMenu(int ana, int alt) {
        int secim;

        while (true) {
            System.out.println("\nÜrünler:");
            for (int i = 0; i < urunler[ana][alt].length; i++) {
                System.out.println((i + 1) + ". "
                        + urunler[ana][alt][i]
                        + " (Stok: " + stoklar[ana][alt][i] + ")");
            }

            System.out.println("0. Geri dön");
            System.out.print("Seçim: ");
            secim = input.nextInt();

            if (secim == 0) return;

            if (secim >= 1 && secim <= urunler[ana][alt].length) {
                if (stoklar[ana][alt][secim - 1] > 0) {
                    stoklar[ana][alt][secim - 1]--;
                    System.out.println("Satış başarılı! Kalan stok: "
                            + stoklar[ana][alt][secim - 1]);
                } else {
                    System.out.println("Stokta ürün yok!");
                }
            } else {
                hataMesaji();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            int menu = anaMenuSec();
            altMenu(menu);
        }
    }
}

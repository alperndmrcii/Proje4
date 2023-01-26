package Veritabani;

import Modeller.Calisanlar.Calisan;
import Modeller.Departmanlar.Departman;

import java.util.ArrayList;

public class Calisanlar {


    // Buradaki calisanList static cünkü proje calismaya basladiği anda oluşması lazım. Bunu bir veritabani
    // gibi görebiliriz. Calisanlarimizin hepsi bu liste icerisinde yer alacak.
    private static ArrayList<Calisan> calisanList = new ArrayList<>();

    // Calisanlari almak icin basit bir getter method
    public static ArrayList<Calisan> getCalisanList() {
        return calisanList;
    }

    // Bir çalışan eklemek için gerekli method.
    public static void addACalisan(Calisan calisan) {
        calisanList.add(calisan);
    }


    // Bir çalışan silmek için gerekli method.
    public static void deleteACalisanWithId(String calisanId) {
   for (Calisan c:calisanList)
    {
        if (c.getCalisanId().equals(calisanId))
            calisanList.remove(c);
    }
     //calisanList.removeIf(c -> c.getCalisanId().equals(calisanId));
    }

    // Departman kodu verilerek, konsola sadece o departmanda calisanlari yazdirmak için
    public static void printDepartmandakiCalisanlar(String departmanKodu) {
        for (Departman d : Departmanlar.getDepartmanList()) {

            if (departmanKodu.equals(d.getDepartmanKodu())) {
                String b = d.getDepartmanKodu();
                {
                    for (Calisan c : calisanList) {
                        if (c.getDepartman().getDepartmanKodu().equals(b))
                        {
                            System.out.println(c);
                        }

                    }
                }
            }
        }
    }

    // Calisanlari konsola yazdirmak için
    public static void printCalisanlar() {
        for (Calisan s: calisanList)
            System.out.println(s);
    }


}

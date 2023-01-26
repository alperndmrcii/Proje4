package Modeller.Calisanlar;

import Modeller.Departmanlar.BilisimTeklonojileriDepartmani;
import Modeller.Departmanlar.Departman;
import Modeller.Departmanlar.YonetimDepartmani;
import Veritabani.Calisanlar;
import Veritabani.Departmanlar;

import java.util.ArrayList;

public class Calisan {

    private String calisanId;
    private String adSoyad;
    private int maas;
    private Departman Departman;
    private String isimKodu = "";

    public Calisan(String adSoyad, int maas, String departmanKodu) {
        this.adSoyad = adSoyad;
        this.maas = maas;
        setDepartman(departmanKodu);
        this.setCalisanId();
        Calisanlar.addACalisan(this);
    }


    // Kullanicinin departman koduna göre, gerekli departman set edilmelidir.
    private void setDepartman(String departmanKodu) {
        for (Departman g : Departmanlar.getDepartmanList()) {
            if (g.getDepartmanKodu().equals(departmanKodu))
                this.Departman = g;
        }

        /*
            İpucu: Departman listesinin (Veritabani.Departmanlar.DepartmanList) içerisindeki departmanların kodları var,
        bu kodlari donguye tutmak ise yarayabilir.
       */
    }

    // Calisanin ID sinin kendisine özel olduğundan bahsetmistik, ID nin nasil kaydedileceği CalisanKaydetmeProjesiTanıtım.txt
    // içerisinde yer aliyor.
    private void setCalisanId() {
        this.calisanId = this.Departman.getDepartmanKodu() + (Calisanlar.getCalisanList().size() + 1) + getCalisanIsimKodu();

        /*
            İpucu: Detayli anlatim CalisanKaydetmeProjesiTanıtım.txt içerisinde.
         */
    }

    // Calisanin ID sinin sonuna isim kodu eklenmesi için, ismi parçalayan bir method.
    private String getCalisanIsimKodu() {
        //   char ilkH = adSoyad.charAt(0);
        //   int bI = adSoyad.indexOf(" ");
        //   char ilkH2 = adSoyad.charAt(bI + 1);
        //   int bI2 = adSoyad.indexOf(" ", bI + 1);
        //  // char ilkH3 = adSoyad.charAt(bI2 + 1);
        //   String basharfler = String.valueOf(ilkH) + String.valueOf(ilkH2);
        isimKodu = String.valueOf(adSoyad.charAt(0));
        for (int i = 0; i < adSoyad.length(); i++) {
            if (adSoyad.charAt(i) == ' ')
                isimKodu = isimKodu.concat(String.valueOf(adSoyad.charAt(i + 1)));

        }
        /*

            Basit string metodlari ise isinice cok yarayacaktir fakat dinamik olmasina dikkat edelim... Mesela 2 isim bir
            soyisim girildiğinde hata vermesin.

         */

        return isimKodu;
    }

    // Calisanin id sini almak icin basit getter method
    public String getCalisanId() {
        return this.calisanId;
    }

    // Calisanin departmanini almak icin basit getter method
    public Departman getDepartman() {
        return this.Departman;
    }

    // Departman adini verebilmek için bir method
    public String getDepartmanAdi() {
        String departmanadi = null;
        if (getDepartman().getDepartmanKodu().equals("YD"))
            departmanadi = "Yönetim Departmani";
        else if (getDepartman().getDepartmanKodu().equals("BTD"))
            departmanadi = "Bilişim Teknolojileri Departmanı";
        else if (getDepartman().getDepartmanKodu().equals("IKD"))
            departmanadi = "İnsan Kaynakları Departmanı";



        /*
                İpucu: Departman Kodu YD ise departman adi Yonetim Departmani olarak kaydedilmelidir.
         */
        return departmanadi;
    }

    // Calisana zam yapilmasi için gerekli bir method
    public static void zamYap(String calisanId) {

        for (Calisan c : Calisanlar.getCalisanList())
            if (c.calisanId.equals(calisanId)) {
                c.maas = c.maas + (c.Departman.getZamOrani() * c.maas) / 100;
            }

        //maas=zam+maas;
        // zam=departman.x.zamoranı


        /*

            İpucu: Calisan ID si kullanilarak yapilmalidir, diğer attributelarin aynilarindan 1 er tane daha
            olabilirdi.

         */
    }

    // Calisanlari yazdırmak için gerekli bir override

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanId='" + calisanId + '\'' +
                ", adSoyad='" + adSoyad + '\'' +
                ", maas=" + maas +
                ", Departman=" + Departman.getClass().getSimpleName() +
                '}';

    }
}


import java.awt.*;
import java.util.Date;

public final class Car {

    private enum model {
        Volvo, Bmw, Tofas, Fiat, Bugatti
    }

    private final int yil;
    private final int kacKisilik;
    private final Date uretimTarihi;
    private final int km;
    private final Color color;

    public Car(int yil, int kacKisilik, Date uretimTarihi, int km, Color color) {
        this.yil = yil;
        this.kacKisilik = kacKisilik;
        this.uretimTarihi = uretimTarihi;
        this.km = km;
        this.color = color;
    }


    public int getYil() {
        return yil;
    }

    public int getKacKisilik() {
        return kacKisilik;
    }

    public Date getUretimTarihi() {
        return uretimTarihi;
    }

    public int getKm() {
        return km;
    }

    public Color getColor() {
        return color;
    }


}

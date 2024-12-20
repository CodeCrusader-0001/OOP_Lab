public class Sphere extends  Figure{
    public Sphere(int r) {
        this.radi =  r;
    }

    @Override
    public void calcArea() {
        area = 4*PI*radi*radi;
    }

    @Override
    public void calcVolume() {
        volume = (4*PI*radi*radi*radi)/3 ;
    }

    @Override
    public void dispArea() {
        System.out.println("Area : "+ area);
    }

    @Override
    public void dispVolume() {
        System.out.println("Volume : "+volume);
    }
}

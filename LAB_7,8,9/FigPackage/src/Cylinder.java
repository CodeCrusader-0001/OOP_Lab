public class Cylinder extends Figure{
    private double height;
    public Cylinder(int r,int h) {
        height = h;
        radi = r;
    }

    @Override
    public void calcArea() {
        area = 2*PI*radi*(height+radi);
    }

    @Override
    public void calcVolume() {
        volume = PI*radi*radi*height ;
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

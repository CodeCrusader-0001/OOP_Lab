public class Cone extends Figure{
    private double slantHeight , height;

    public Cone(int r, double height) {
        this.radi = r;
        this.slantHeight = Math.pow(r*r+height*height,0.5);
        this.height = height;
    }

    @Override
    public void calcArea() {
        area = PI*radi*(radi+slantHeight);
    }

    @Override
    public void calcVolume() {
        volume = (PI*radi*radi*height)/3;
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

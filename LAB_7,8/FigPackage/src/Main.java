public class Main {
    public static void main(String[] args) {
        Cone cone = new Cone(1,1);
        cone.calcVolume();
        cone.calcArea();
        cone.dispArea();
        cone.dispVolume();

        Sphere sphere = new Sphere(5);
        sphere.calcArea();
        sphere.dispArea();
        sphere.calcVolume();
        sphere.dispVolume();

        Cylinder cylinder = new Cylinder(5,10);
        cylinder.calcArea();
        cylinder.calcVolume();
        cylinder.dispArea();
        cylinder.dispVolume();
    }
}
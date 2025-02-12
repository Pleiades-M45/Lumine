interface Comparable{
    public double volume();
    public int compareByVolume(Comparable other);
}

class Cuboid implements Comparable{
    double length, width, height;
    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double volume() {
        return length * width * height;
    }

    @Override
    public int compareByVolume(Comparable other) {
        if (volume() < other.volume()) {
            return -1;
        }
        else if (volume() > other.volume()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}

class Cylinder implements Comparable{
    double radius, height;
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public int compareByVolume(Comparable other) {
        if (volume() < other.volume()) {
            return -1;
        }
        else if (volume() > other.volume()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
public class VolumeDemo {
    public static void main(String[] args){
        Cuboid c1 = new Cuboid(2,2,2);
        Cuboid c2 = new Cuboid(2,2,2);

    }
}

import java.util.HashSet;
import java.util.Objects;

class Attendee {
    String name, email;
    int regid;

    public Attendee(String n, String e, int r) {
        name = n;
        email = e;
        regid = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee at = (Attendee) o;
        return regid == at.regid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regid);
    }

    @Override
    public String toString() {
        return "Registration ID: " + regid + ", Name: " + name + ", Email: " + email;
    }
}

public class HashSetAttendee {
    public static void main(String[] args) {
        HashSet<Attendee> at = new HashSet<>();

        Attendee a1 = new Attendee("John", "john@example.com", 1);
        Attendee a2 = new Attendee("Jane", "jane@example.com", 2);
        Attendee a3 = new Attendee("Jfas", "jda@example.com", 3);
        Attendee a4 = new Attendee("John Duplicate", "john@duplicate.com", 1);

        at.add(a1);
        at.add(a2);
        at.add(a3);
        at.add(a4);

        for (Attendee x : at) {
            System.out.println(x);
        }
    }
}

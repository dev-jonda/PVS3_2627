package jondis.oop.inheritance;

public class Hospital {

    public static void main(String[] args) {
        Doctor d = new Doctor("Jeff");
        System.out.println(d.name);
        System.out.println(d.salary);

        Surgeon s = new Surgeon("Pepa");
        System.out.println(s.name);
        System.out.println(s.salary);

        System.out.println();
        s.diagnose();
        s.surgery();

        CardiacSurgeon cs = new CardiacSurgeon("Max");
    }
}

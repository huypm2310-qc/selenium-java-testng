package javaTester;

public class Topic_02_Primitive_Referemce {
    int x;


    public static void main(String[] args) {
        int x = 42;
        int y = x;
        System.out.println("X = " + x);
        System.out.println("Y = " + y);

        x = 50;
        System.out.println("X = " + x);
        System.out.println("Y = " + y);


        //Instance 1
        Topic_02_Primitive_Referemce c = new Topic_02_Primitive_Referemce();
        c.x = 42;
        System.out.println(c.x);

        //Instance 2
        Topic_02_Primitive_Referemce d = c;
        System.out.println(d.x);

        c.x = 100;
        System.out.println(c.x);
        System.out.println(d.x);

    }
}

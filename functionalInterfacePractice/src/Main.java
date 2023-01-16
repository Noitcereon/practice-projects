import models.Crocodile;
import models.FireDragon;
import models.ReptileEgg;
import models.interfaces.Reptile;

public class Main {
    public static void main(String[] args) {
        FireDragon fireDragon = new FireDragon();
        System.out.println(fireDragon);
        ReptileEgg egg = fireDragon.layEgg();
        Reptile childFireDragon = egg.hatch();
        System.out.println(childFireDragon);
        ReptileEgg egg2 = childFireDragon.layEgg();
        Reptile childFireDragon2 = egg2.hatch();
        System.out.println(childFireDragon2);
        Crocodile crocodile = new Crocodile();
        ReptileEgg egg3 = crocodile.layEgg();
        Reptile crocodileChild = egg3.hatch();
        System.out.println(crocodileChild);
        Reptile reptile2 = egg3.hatch();
        System.out.println(reptile2);
    }
}
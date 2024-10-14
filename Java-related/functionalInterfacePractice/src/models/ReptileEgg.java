package models;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import models.interfaces.Hatchable;
import models.interfaces.Reptile;

public class ReptileEgg {
    private final Reptile reptile;
    private final Logger logger = LoggerFactory.getLogger(ReptileEgg.class);
    private boolean isHatched = false;

    public ReptileEgg(Hatchable createReptile){
        reptile = createReptile.hatch();
    }

    public Reptile hatch(){
        if(isHatched){
            logger.warn("Egg has already hatched.");
            return null;
        }
        isHatched = true;
        return reptile;
    }

    @Override
    public String toString() {
        return "ReptileEgg{" +
                "reptile=" + reptile +
                ", logger=" + logger +
                ", isHatched=" + isHatched +
                '}';
    }
}

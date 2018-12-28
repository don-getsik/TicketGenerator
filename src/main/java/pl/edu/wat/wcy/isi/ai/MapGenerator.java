package pl.edu.wat.wcy.isi.ai;

import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.wcy.isi.ai.MapValues.*;

public class MapGenerator {

    private Map<MapValues, String> varMap;

    public MapGenerator() {
        varMap = new HashMap<MapValues, String>();
    }

    public MapGenerator putConcert (String concertName) {
        this.varMap.put(CONCERT, concertName);
        return this;
    }

    public MapGenerator putCompositor (String compositorName) {
        this.varMap.put(COMPOSTIOR, compositorName);
        return this;
    }

    public MapGenerator putDate (String date) {
        this.varMap.put(DATE, date);
        return this;
    }

    public MapGenerator putRow (String row) {
        this.varMap.put(ROW, row);
        return this;
    }

    public MapGenerator putPosition (String position) {
        this.varMap.put(POSITION, position);
        return this;
    }

    public MapGenerator putEmail (String email) {
        this.varMap.put(EMAIL, email);
        return this;
    }

    public MapGenerator putPrice (String price) {
        this.varMap.put(PRICE, price);
        return this;
    }

    public MapGenerator putDiscount (String discount) {
        this.varMap.put(DISCOUNT, discount);
        return this;
    }

    public Map get() {
        return varMap;
    }
}

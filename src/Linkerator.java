/**
 * @author Nile Cochen
 * Linkerator class is not used in the final program. Used to find distance between tiles
 */
public class Linkerator {
    private Tile tile1; //copy of first tile
    private Tile tile2; //copy of second tile
    private int weight; //weight to be calculated

    /**
     * Constructor takes in two tiles and automatically calculates weight
     * @param tile1 first tile definition
     * @param tile2 second tile definition
     * @param weight weight to be calculated
     */
    public Linkerator(Tile tile1, Tile tile2, int weight) {
        //define tiles
        this.tile1 = tile1;
        this.tile2 = tile2;

        if (weight == 1) { //calculate new weight if weight is equal to one (allows any other weight to be passed in manually)
            //Calculate new weight with pythagorean's theorem
            int x = Math.abs(tile1.getX()-tile2.getX());
            int y = Math.abs(tile1.getY()-tile2.getY());
            weight = (int)Math.sqrt(x*x + y*y * 1.0);
        }

        //define weight as newly calculated weight
        this.weight = weight;
    }

    /**
     * getter for tile1
     * @return returns tile 1
     */
    public Tile getTile1() {
        return tile1;
    }

    /**
     * getter for tile2
     * @return returns tile 2
     */
    public Tile getTile2() {
        return tile2;
    }

    /**
     * getter for weight
     * @return returns weight
     */
    public int getWeight() {
        return weight;
    }
}
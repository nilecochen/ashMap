public class Linkerator {
    private Tile tile1;
    private Tile tile2;
    private int weight;

    public Linkerator(Tile tile1, Tile tile2, int weight) {
        this.tile1 = tile1;
        this.tile2 = tile2;
        if (weight == 1) {
            int x = Math.abs(tile1.getX()-tile2.getX());
            int y = Math.abs(tile1.getY()-tile2.getY());
            weight = (int)Math.sqrt(x*x + y*y * 1.0);
        }
        this.weight = weight;
    }

    public Tile getTile1() {
        return tile1;
    }

    public Tile getTile2() {
        return tile2;
    }

    public int getWeight() {
        return weight;
    }
}
package SupportClasses;
// Class is written by Kristian Urban 163301
public class Die {
    private int face;
    private final int maxsides = 6;
    private final int minsides=1;
    private final int range=maxsides-minsides+1;
    public Die()
    {
        face=0;
    }

    public void roll() {
        face = (int) (Math.random() * range) + minsides;
    }
    public String toString() {
        return String.valueOf(face);
    }
    public int get() {
        return face;
    }
}
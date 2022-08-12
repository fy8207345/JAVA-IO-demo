public class LeakFactory
{//Just so that we have some data to leak
    int myID = 0;
    // Necessary because our Leak class is non-static
    public Leak createLeak()
    {
        return new Leak();
    }

    // Mass Manufactured Leak class
    public static class Leak
    {//Again for a little data.
        int size = 1;
    }
}


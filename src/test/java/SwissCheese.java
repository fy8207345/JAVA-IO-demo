public class SwissCheese
{//Can't have swiss cheese without some holes
    public LeakFactory.Leak[] myHoles;

    public SwissCheese()
    {
        // let's get the holes and store them.
        myHoles = new LeakFactory.Leak[10000];

        for (int i = 0; i<10000; i++)
        {//Store them in the class member
            myHoles[i] = new LeakFactory().createLeak();
        }

        // Yay! We're done!

        // Buh-bye LeakFactory. I don't need you anymore...
    }
}
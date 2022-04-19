package ie.app.models;

/**
 * Created by ddrohan on 22/10/2015.
 */
public class Donation
{
    public String id;
    public int    amount;
    public String method;
    public int    upVotes;

    public Donation (int amount, String method, int upvotes)
    {
        this.amount = amount;
        this.method = method;
        this.upVotes = upvotes;
    }

    public Donation ()
    {
        this.amount = 0;
        this.method = "";
        this.upVotes = 0;
    }

    public String toString()
    {
        return id + ", " + amount + ", " + method + ", " + upVotes;
    }

}


package data;

public class Subscription {
    private int idSubscription; // Subscription ID
    private int idContract; // Reference to the contract
    private String subscriptionDate; // Subscription date

    // Constructor
    public Subscription(int idSubscription, int idContract, String subscriptionDate) {
        this.idSubscription = idSubscription;
        this.idContract = idContract;
        this.subscriptionDate = subscriptionDate;
    }

    // Getter and Setter methods
    public int getIdSubscription() { return idSubscription; }
    public void setIdSubscription(int idSubscription) { this.idSubscription = idSubscription; }
    public int getIdContract() { return idContract; }
    public void setIdContract(int idContract) { this.idContract = idContract; }
    public String getSubscriptionDate() { return subscriptionDate; }
    public void setSubscriptionDate(String subscriptionDate) { this.subscriptionDate = subscriptionDate; }
}

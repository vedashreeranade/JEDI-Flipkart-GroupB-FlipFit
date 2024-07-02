package com.flipkart.bean;

/**
 * Represents a Customer in the Flipkart system, extending the User class.
 * This class adds membership details specific to customers who have subscriptions or memberships,
 * enabling the tracking and management of additional customer privileges and access rights based
 * on their membership status.
 */
public class Customer extends User {
    private int membershipId;         // Unique identifier for the customer's membership
    private String membershipType;    // Type of membership (e.g., "Gold", "Silver", "Bronze")

    /**
     * Gets the membership ID for this customer.
     * The membership ID is a unique identifier that represents the customer's subscription or membership.
     *
     * @return The membership ID as an integer.
     */
    public int getMembershipId() {
        return membershipId;
    }

    /**
     * Sets the membership ID for this customer.
     * This method is used to assign a new membership ID to the customer, typically done during the registration
     * of a new membership or updating of an existing membership.
     *
     * @param membershipId The new membership ID to be set.
     */
    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    /**
     * Gets the type of membership for this customer.
     * Membership type can indicate the level of benefits the customer receives and can include types
     * like "Gold", "Silver", or "Bronze".
     *
     * @return The membership type as a String.
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * Sets the type of membership for this customer.
     * This method allows for changing the membership type, which can affect the services and benefits
     * the customer is entitled to within the system.
     *
     * @param membershipType The new membership type to be set (e.g., "Gold", "Silver", "Bronze").
     */
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}

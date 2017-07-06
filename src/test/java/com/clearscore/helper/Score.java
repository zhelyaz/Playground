package com.clearscore.helper;

/* Plain java object that will help us extract
 * values from the data table in the feature file.
 */
public class Score {
	public String interest_rate;
	public String costs;
	public String cards_availale;

	/**
	 * @return the interest_rate
	 */
	public String getInterest_rate() {
		return interest_rate;
	}

	/**
	 * @param interest_rate
	 *            the interest_rate to set
	 */
	public void setInterest_rate(String interest_rate) {
		this.interest_rate = interest_rate;
	}

	/**
	 * @return the costs
	 */
	public String getCosts() {
		return costs;
	}

	/**
	 * @param costs
	 *            the costs to set
	 */
	public void setCosts(String costs) {
		this.costs = costs;
	}

	/**
	 * @return the cards_availale
	 */
	public String getCardsAvailable() {
		return cards_availale;
	}

	/**
	 * @param cards_availale
	 *            the cards_availale to set
	 */
	public void setCardsAvailale(String cards_availale) {
		this.cards_availale = cards_availale;
	}

}
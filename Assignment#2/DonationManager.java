package DataManager;

import DataStructures.Container;
import DataStructures.DonationPackage;
import DataStructures.Recipient;
import DataStructures.RecipientLine;
import DataStructures.Volunteer;
import DataStructures.VolunteerLine;
import Exceptions.ContainerException;
import Exceptions.RecipientException;
import Exceptions.VolunteerException;

/**
 * The DonationManager class simulates the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient.
 * @author Oumar Diallo
 *
 */

public class DonationManager implements DonationManagerInterface {

	@SuppressWarnings("rawtypes")
	Container container =  new Container(0);
	VolunteerLine volunteerLine = new VolunteerLine();
	RecipientLine recipientLine = new RecipientLine();
	private Recipient recipient;
	private DonationPackage donationPackage;
	private Volunteer volunteer;
	private double weight;


	public DonationManager(){
	}

	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException if container is full
	 */

	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return (container.loadContainer(dPackage));
	}

	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully , false if queue is full
	 * @throws VolunteerException if the Volunteer Line queue is full
	 */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return(volunteerLine.addNewVolunteer(v));
	}

	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException if the Recipient line is full
	 */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return(recipientLine.addNewRecipient(r));
	}

	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @returns 1, if there are no volunteer, 2 if there are no recipients, 3 if container is empty, and 0 if the operation is successful
	 * 
	 */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if(!volunteerLine.volunteerLineEmpty()) {

			if(!recipientLine.recipientLineEmpty()){

				if(!container.isEmpty()){

					this.donationPackage = container.removePackageFromContainer();
					this.weight = donationPackage.getWeight();
					this.volunteer = volunteerLine.volunteerTurn();
					volunteerLine.addNewVolunteer(volunteer);
					this.recipient = recipientLine.recipientTurn();
				}
				else {
					throw new ContainerException("Container is empty.");
				}
			}
			else {
				throw new RecipientException ("Recipient Queue is empty.");
			}
		}
		else {
			throw new VolunteerException ("Volunteer Queue is empty.");
		}
		int final_weight = (int) weight;
		return final_weight;
	}


	@Override
	public DonationPackage[] managerArrayPackage() {
		try {
			return container.toArrayPackage();
		} catch (ContainerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Returns an array containing the volunteers added into the volunteers Queue
	 * @return an array of the volunteers in the queue
	 */
	@Override
	public Recipient[] managerArrayVolunteer() {
		
		return volunteerLine.toArrayVolunteer();
	}
	/**
	 * Returns an array containing the recipients added into the recipients Queue
	 * @return an array of the Recipients in the queue
	 */
	@Override
	public Recipient[] managerArrayRecipient() {
		
		return recipientLine.toArrayRecipient();
	}

	public String toString() {
		return volunteer.getName() + " donated " + donationPackage.getDescription() +
				" that weighs " + weight + " lbs to " + recipient.getName() + "." ;
	}



}

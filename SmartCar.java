/*

Project: CarConnect

Written By: Erik Ronstrom

Class: Smart Car

Function: The class of the project that contains a Smart Car's basic information and methods.

*/
package carconnect;

public class SmartCar extends BasicCar{

	private String mStatus;
	private Message mMessage;
	//private carList mCarsMet;  //NYI
	//private commList mHistory;  //NYI

	//Creates a stateless car not placed anywhere
	SmartCar(long pID, String pModel) {
		super(pID, pModel);
	}

	//Creates a car placed with locational data
	SmartCar(long pID, String pModel, float pDirection, float pLongitude,
	 float pLatitude) {
		 super(pID, pModel, pDirection, pLongitude, pLatitude);
	}

	/*smartCar(float pDirection, Location pLocation, float pLongitude,
	 float pLatitude, String pStatus, carList CarsMet, commList History){
		mDirection = Direction;
		mLongitude = Longitude;
		mLatitude = Latitude;
		mStatus = Status;
/*
		this.mCarsMet = CarsMet;
		this.mHistory = History;
	}*/

	// Getters and setters:

	public String getStatus() {
		return mStatus;
	}

	public void setStatus(String pStatus) {
		mStatus = pStatus; //should we create our own type "STATUS" so that we sanitize this input?
	}


	public void getCarsMet() { //NYI
		//return mCarsMet;
	}

	public void getHistory() { //NYI
		//return this.mHistory;
	}

	public void getMessage() { //NYI
		//return this.mOut;
	}

	public void appendCarsMet() { //NYI

	}

	public void setMessage(Message pMessage){
		mMessage = pMessage;
	}

	// Methods
	//Broadcasts message to all cars in range
	public void send() {
		mMessage = new Message(this);
		mMessage.createMessage();
		System.out.println("Message is:" + mMessage.getMessage());
		System.out.println("Message hash is:" + mMessage.getHash());
		//Add Sockets later
	}

	//Overloads send to direct message to specific car with optional message
	public void send(long pID, String pMessage) {
		mMessage = new Message(this, pMessage);
		mMessage.createMessage();
		System.out.println("Message is:" + mMessage.getMessage());
		System.out.println("Message hash is:" + mMessage.getHash());
		// Later add sockets to send data
	}

	//Listens for all traffic
	//Perhaps better implemented as a thread?
	public void receive() {
		// Later add sockets to receive data
	}

	//make getters and setters for data.
	//make constructors

}

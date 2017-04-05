package carconnect;
import java.lang.Character;

public class Message {

  private BasicCar mCar = null;
  private byte mType = 0;
  private long mTimestamp = 0;
  private String mHash = "";
  private String mOpMessage = "";
  private String mMessage = "";

  Message(BasicCar pCar) {
    mCar = pCar;
  }

  Message(BasicCar pCar, String pOptionalMessage) {
    mCar = pCar;
    mOpMessage = pOptionalMessage;
  }

  //Constructor to recieve a sent message and break it down into its components
  Message(String pFullMessage) {
    mMessage = pFullMessage;
    int state = 0, start = 0, delim = 0;
    String buffer = "";
    //Use FSM to create a smartCar object
    for (char ch: mMessage.toCharArray()) {
      delim++;
      if (ch == '/') {
        //If not length of 0 between delimiters assign content to buffer
        if (delim - start > 1) {
          buffer = mMessage.substring(start, delim);
        }
        else {
          buffer = "";
        }
        //Assign buffer to variables depending on state
        switch (state) {
          case 0:
          //Assign to car id
          break;
          case 1:
          //Assign to car model
          break;
          case 8:
          //Assign to optional message
          break;
          case 9:
          //Assign to hash
          //End of message
          break;
        }
        //Next variable
        state++;
        start = delim + 1;
      }
    }
  }

  private void setTime() {
    mTimestamp = System.currentTimeMillis();
  }

  //This method will add the ascii values of mMessage
  //mod the data by 0x7FFF the data to produce a hash
  private void createHash() {
    int pool = 0;
    if (!mMessage.equals("")) {
      for (char ch: mMessage.toCharArray()) {
        pool += Character.getNumericValue(ch);
      }
    }
    pool %= 0x7FFF;
    mHash = Integer.toString(pool);
  }

  public String getHash() {
    return mHash;
  }

  //This method will create a message based on car properties
  //and the optional message supplied
  //ID,model,direction,long,lat,speed,accel,time,op,hash
  public void createMessage() {
    String buffer = "";
    buffer = buffer + Long.toString(mCar.getID()) + "/";
    buffer = buffer + mCar.getModel() + "/";
    buffer = buffer + Double.toString(mCar.getDirection()) + "/";
    buffer = buffer + Double.toString(mCar.getyPos()) + "/";
    buffer = buffer + Double.toString(mCar.getxPos()) + "/";
    buffer = buffer + Double.toString(mCar.getSpeed()) + "/";
    buffer = buffer + Double.toString(mCar.getAcceleration()) + "/";
    setTime();
    buffer = buffer + Long.toString(mTimestamp) + "/";
    buffer = buffer + mOpMessage;
    mMessage = buffer;
    createHash();
  }

  public String getMessage() {
    return mMessage;
  }

  public BasicCar getCar() {
    return mCar;
  }

  public void setOptional(String pMessage) {
    mOpMessage = pMessage;
  }

  public String getOptional() {
    return mOpMessage;
  }
}

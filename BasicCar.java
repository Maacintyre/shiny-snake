/*
Project: CarConnect
Written By: Cynthia Wooldridge, Pete Lozano

Class: Basic Car
Function: The base class of the project that contains a basic car's information
*/
import java.math.*;

package carconnect;

public class BasicCar {

    private long mID;
    private String mModel;
    //private Location mLocation;
    private float mSpeed;
    private float mAcceleration;
    private float mDirection;     //Angle from east
    private float myPos;
    private float mxPos;
    private boolean placed;

    //Creates a stateless car with no location
    BasicCar (long pID, String pModel) {
      mID = pID;
      mModel = pModel;
      placed = false;
    }

    //Creates a car with locational data
    BasicCar(long pID, String pModel, /* Location pLocation,*/
     float pDirection, float pyPos, float pxPos) {
      mID = pID;
      //mLocation = pLocation;
      mDirection = pDirection;
      myPos = pyPos;
      mxPos = pxPos;
      mModel = pModel;
      placed = true;
    }

    /*BasicCar(long pID, String pModel, Location pLocation,
      float pDirection, float pyPos, float pxPos, float pSpeed,
      float pAcceleration){
        mID = pID;
        //mLocation = pLocation;
        mDirection = pDirection;
        myPos = pyPos;
        mxPos = pxPos;
        mSpeed = pSpeed;
        mAcceleration = pAcceleration;
        mModel = pModel;
    }*/

    public long getID() {
        return mID;
    }
    public void setID(long pID) {
        mID = pID;
    }

    public float getSpeed() {
        return mSpeed;
    }
    public void setSpeed(float pSpeed) {
        mSpeed = pSpeed;
    }

    public float getAcceleration() {
        return mAcceleration;
    }
    public void setAcceleration(float pAcceleration) {
        mAcceleration = pAcceleration;
    }

    public float getDirection() {
  		return mDirection;
  	}

    public void setDirection(float pDirection) {
      if (pDirection >= 0f && pDirection < 360f) {
        mDirection = pDirection;
      }
  	}

  	public float getyPos() {
  		return myPos;
  	}

    public void setyPos(float pyPos) {
  		myPos = pyPos; //should we sanitize this so that only real logitudes and xPoss are possible?
  	}

  	public float getxPos() {
  		return mxPos;
  	}

  	public void setxPos(float pxPos) {
  		mxPos = pxPos;
  	}

    public String getModel() {
        return mModel;
    }
    public void setModel(String pModel) {
        mModel = pModel;
    }

    //Calculates change in yPos xPos
    //and location based on time interval provided
    public void drive(float pTime) {

      if (placed) {
        System.out.println("I am driving.");
        float xComp = 0.0f;
        float yComp = 0.0f;
        mSpeed = mSpeed + mAcceleration * pTime;

        if (mDirection <= 90f) {
          xComp = mSpeed * cos(mDirection);
          yComp = mSpeed * cos(90f - mDirection);
        } else if (mDirection <= 180f) {
          xComp = mSpeed * cos(180f - mDirection);
          xComp *= -1f;
          yComp = mSpeed * cos(mDirection- 90f);
        } else if (mDirection <= 270f) {
          xComp = mSpeed * cos(mDirection - 180f);
          xComp *= -1f;
          yComp = mSpeed * cos(270f - mDirection);
          yComp *= -1f;
        } else {
          xComp = mSpeed * cos(360f - mDirection);
          yComp = mSpeed * cos(mDirection - 270f);
          yComp *= -1f;
        }

        mxPos += xComp * pTime;
        myPos += yComp * pTime;
      } else {
        System.out.println("I am not driving.");
      }
    }

    public void getInfo() {
      System.out.format("%s%d\n%s%s\n%s%f\n%s%f\n%s%f\n%s%f\n%s%f\n"
      ,"ID: ", mID
      ,"Model: ", mModel
      ,"Speed: ", mSpeed
      ,"Acceleration: ", mAcceleration
      ,"Direction: ", mDirection
      ,"X Position: ", mxPos
      ,"Y Position: ", myPos);
    }

    private void isDrivable() {
      
    }
}

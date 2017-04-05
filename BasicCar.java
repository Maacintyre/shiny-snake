/*
Project: CarConnect
Written By: Cynthia Wooldridge, Pete Lozano

Class: Basic Car
Function: The base class of the project that contains a basic car's information
*/
package carconnect;

import java.lang.*;

public class BasicCar {

    private long mID;
    private String mModel;
    //private Location mLocation;
    private double mSpeed;
    private double mAcceleration;
    private double mDirection;     //Angle from east
    private double myPos;
    private double mxPos;
    private boolean placed;
    private boolean wrecked;
    private boolean braking;

    //Creates a stateless car with default location
    BasicCar (long pID, String pModel) {
      mID = pID;
      mDirection = 0f;
      myPos = 0f;
      mxPos = 0f;
      mModel = pModel;
      placed = false;
      wrecked = false;
      braking = false;
    }

    //Creates a car with locational data
    BasicCar(long pID, String pModel, /* Location pLocation,*/
     double pDirection, double pyPos, double pxPos) {
      mID = pID;
      //mLocation = pLocation;
      mDirection = pDirection;
      myPos = pyPos;
      mxPos = pxPos;
      mModel = pModel;
      placed = true;
      wrecked = false;
      braking = false;
    }

    /*BasicCar(long pID, String pModel, Location pLocation,
      double pDirection, double pyPos, double pxPos, double pSpeed,
      double pAcceleration){
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

    public double getSpeed() {
        return mSpeed;
    }
    public void setSpeed(double pSpeed) {
        mSpeed = pSpeed;
    }

    public double getAcceleration() {
        return mAcceleration;
    }
    public void setAcceleration(double pAcceleration) {
        mAcceleration = pAcceleration;
        if (mAcceleration < 0) {
          braking = true;
        } else {
          braking = false;
        }
    }

    public double getDirection() {
  		return mDirection;
  	}

    public void setDirection(double pDirection) {
      if (pDirection >= 0f && pDirection < 360f) {
        mDirection = pDirection;
      }
  	}

  	public double getyPos() {
  		return myPos;
  	}

    public void setyPos(double pyPos) {
  		myPos = pyPos;
  	}

  	public double getxPos() {
  		return mxPos;
  	}

  	public void setxPos(double pxPos) {
  		mxPos = pxPos;
  	}

    public String getModel() {
        return mModel;
    }

    public void setModel(String pModel) {
        mModel = pModel;
    }

    public boolean isWrecked() {
      return wrecked;
    }

    //Calculates change in yPos xPos
    //and location based on time interval provided
    public void drive(double pTime) {

      if (placed && !wrecked) {
        System.out.println("I am driving.");
        double xComp = 0.0f;
        double yComp = 0.0f;
        double rDirection = Math.toRadians(mDirection);
        final double r90 = Math.toRadians(90d);
        final double r180 = Math.toRadians(180d);
        final double r270 = Math.toRadians(270d);
        final double r360 = Math.toRadians(360d);
        mSpeed = mSpeed + mAcceleration * pTime;

        if (rDirection <= r90) {
          xComp = mSpeed * Math.cos(rDirection);
          yComp = mSpeed * Math.cos(r90 - rDirection);
        } else if (rDirection <= r180) {
          xComp = mSpeed * Math.cos(r180 - rDirection);
          xComp *= -1f;
          yComp = mSpeed * Math.cos(rDirection- r90);
        } else if (rDirection <= r270) {
          xComp = mSpeed * Math.cos(rDirection - r180);
          xComp *= -1f;
          yComp = mSpeed * Math.cos(r270 - rDirection);
          yComp *= -1f;
        } else {
          xComp = mSpeed * Math.cos(r360 - rDirection);
          yComp = mSpeed * Math.cos(rDirection - r270);
          yComp *= -1f;
        }
        mxPos += xComp * pTime;
        myPos += yComp * pTime;
      } else {
        System.out.println("I am not driving.");
      }
    }

    public double getDistance(BasicCar pCar) {
      return Math.hypot(pCar.getxPos() - mxPos, pCar.getyPos() - myPos);
    }

    public double getDirection(BasicCar pCar) {
      double rAngle;
      if (pCar.getxPos() != 0 && pCar.getyPos() != 0) {
        if (pCar.getxPos() == 0) {
          if (pCar.getyPos() > 0) {
            return 90d;
          } else {
            return 270d;
          }
        } else if (pCar.getyPos() == 0){
          if (pCar.getxPos() > 0) {
            return 0d;
          } else {
            return 180d;
          }
        }
        rAngle = Math.atan(pCar.getyPos() / pCar.getxPos());
        rAngle = Math.toRadians(rAngle);

        if (pCar.getxPos() >= 0) {
          if (pCar.getyPos() < 0) {
            return 270d + rAngle;
          } else {
            return rAngle;
          }
        } else {
          if (pCar.getyPos() < 0) {
            return 180d + rAngle;
          } else {
            return 90d + rAngle;
          }
        }
      }
      return 0d;
    }

    public boolean collided(BasicCar pCar) {
      if (Math.abs(getDistance(pCar)) < 1) {
        wrecked = true;
      } else {
        wrecked = false;
      }
      return wrecked;
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

    private boolean isDrivable() {
      /*if (placed == false) {
        if (mID >= 0f && mSpeed >= 0f &&
              mAcceleration >= 0f && mDirection >= 0f) {
                placed = true;
                return placed;
              }
        return placed;
      }
      else {
        return placed;
      }*/
      return false;
    }
}

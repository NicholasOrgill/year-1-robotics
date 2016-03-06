package ServerClasses;

import interfaces.*;
import rp.robotics.navigation.GridPose;

import java.util.ArrayList;

import static interfaces.IMessage.fromString;


public class Robot implements IRobot {
    private final String address;
    private int id;
    private Connection connection;

    public Robot(int id, String address) {
        this.id = id;
        this.address = address;
    }

    /**
     * Get the robots position on the grid
     *
     * @return The robots position on the grid
     */
    @Override
    public GridPose getPose() {
        return null;
    }

    /**
     * Set the robots position on the grid
     *
     * @param _pose The new position of the robot
     */
    @Override
    public void setPose(GridPose _pose) {

    }

    /**
     * Get the state of the robot
     *
     * @return The state of the robot
     */
    @Override
    public RobotState getState() {
        return null;
    }

    /**
     * Set the state of the robot
     *
     * @param _state The new state of the robot
     */
    @Override
    public void setState(RobotState _state) {

    }

    /**
     * Assign a pick to the current robot
     *
     * @param _pick The pick to be assigned
     */
    @Override
    public void assignPick(IPick _pick) {

    }

    /**
     * Assign a list of picks to the robot
     *
     * @param _picks The list of picks to be assigned
     */
    @Override
    public void assignPicks(ArrayList<IPick> _picks) {

    }

    /**
     * Get the route for the robot
     *
     * @return The robots route
     */
    @Override
    public IRoute getRoute() {
        return null;
    }

    /**
     * Set the route for the current position to the next pick
     *
     * @param _route The route
     */
    @Override
    public void setRoute(IRoute _route) {

    }

    /**
     * Get the list of picks for the robot
     *
     * @return The list of picks for the robot
     */
    @Override
    public ArrayList<IPick> getPicks() {
        return null;
    }

    /**
     * Send a message to the physical robot
     *
     * @param _message
     */
    @Override
    public void sendMessage(IMessage _message) {

    }

    /**
     * Wait for a message to be received from the robot
     *
     * @return The message received from the robot
     */
    @Override
    public IMessage receiveMessage() {
        try {
            return fromString(connection.getReceivedQueue().take());
        } catch (InterruptedException e) {
            return null;
        }
    }

    /**
     * Returns the robot's unique identifier.
     *
     * @return An integer identifying the robot uniquely.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Returns the robot's bluetooth address.
     *
     * @return A string representation of the bluetooth address.
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Give our virtual "robot" a personal channel to communicate with the NXT.
     *
     * @param c The connection object, created by ConnectionManager.
     */
    @Override
    public void setConnection(Connection c) {
        connection = c;
    }
}

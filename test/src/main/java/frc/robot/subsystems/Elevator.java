package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Elevator extends Subsystem {
	OI oi;

	public boolean isLowSwitchSet() {
		if (RobotMap.limitSwitchBottom.get() == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTopSwitchSet() {
		if (RobotMap.limitSwitchTop.get() == true) {
			return true;
		} else {
			return false;
		}
	}

	public void moveUp() {
		// Moves the motors to grab ball
		double speed = oi.getElevatorSpeed();
		if (speed < 0.0) {
			speed = 0.0;
		}

		if (RobotMap.limitSwitchTop.get() == true) {
			RobotMap.Winch.set(0.0);
		} else {
			RobotMap.Winch.set(speed);
		}
	}

	public void moveDown() {
		double speed = oi.getElevatorSpeed();
		System.out.println("in movedown()");
		if (speed > 0.0) {
			speed = 0.0;
		}
		if (RobotMap.limitSwitchBottom.get() == true) {
			RobotMap.Winch.set(0.0);
		} else {
			RobotMap.Winch.set(speed);
		}
	}

	public void moveElevator(double speed) {

		if (speed > 0) {
			boolean top = RobotMap.limitSwitchTop.get();
			if (top == true) {
				// do nothing
			} else {
				RobotMap.Winch.set(speed);
			}
		}
		else if (speed < 0) {
			boolean bot = RobotMap.limitSwitchBottom.get();
			if (bot == true) {
				// do nothing
			} else {
				RobotMap.Winch.set(speed);
			}
		}
		else {
			RobotMap.Winch.set(0.0);
		}
	}

	public void stop() {
		RobotMap.Winch.set(0.0);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MoveElevator());
	}
}

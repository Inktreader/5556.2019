/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Talon leftFrontTalon =null;
  Talon leftBackTalon =null;
  Talon rightFrontTalon =null;
  Talon rightBackTalon =null;
  DifferentialDrive differentialDrive = null;

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new DriveArcade());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public Drivetrain(){
    //talons
    leftFrontTalon = new Talon(RobotMap.Left_Front_Talon);
    leftBackTalon = new Talon(RobotMap.Left_Back_Talon);
    rightFrontTalon = new Talon(RobotMap.Right_Front_Talon);
    rightBackTalon = new Talon(RobotMap.Right_Back_Talon);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void arcadeDrive(double moveSpeed,double rotateSpeed){
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);


  }
}

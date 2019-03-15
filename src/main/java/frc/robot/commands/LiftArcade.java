/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftArcade extends Command {
 //maybe declare these as constants in robotmap
  DigitalInput forwardLimitSwitch = new DigitalInput(1);
  DigitalInput reverseLimitSwitch = new DigitalInput(0);


  public LiftArcade() {

    requires(Robot.m_liftSubsystem);
    

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    

  

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //double MoveSpeed = -Robot.m_oi.liftJoystick.getRawAxis(RobotMap.LIFT_JOYSTICK);
    double RotateSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.GHOST_TALON);
    double MoveSpeedPre = -Robot.m_oi.driverController.getRawAxis(RobotMap.LIFT_JOYSTICK);
    // put if/then here
    boolean isrevLimitSwitch = reverseLimitSwitch.get();
    boolean isforLimitSwitch = forwardLimitSwitch.get();

    //double MoveSpeedPre = Robot.m_oi.driverController.getY();

//if true, it doesnt move
    ///if ((isforLimitSwitch == true) && (MoveSpeedPre < 0)) {
     //MoveSpeedPre = Math.min(MoveSpeedPre, 0);
   //  MoveSpeedPre = 0;
   /// } 
     
   // if ((isrevLimitSwitch == true) && (MoveSpeedPre > 0)) {
     // MoveSpeedPre = Math.max(MoveSpeedPre, 0);
    // MoveSpeedPre = 0;
   // } 
      //Robot.m_liftSubsystem.LiftJoyControl(MoveSpeedPre);
    double MoveSpeed = MoveSpeedPre;
     
    //test to see if this effects ability 
    //if (reverseLimitSwitch.get()){
      //RotateSpeed = Math.min(RotateSpeed, 0);
    //}else if (forwardLimitSwitch.get()){
      //RotateSpeed
    //}

    

     
    

     //double moveSpeed = -Robot.m_oi.liftJoystick.getRawAxis(RobotMap.MOVE_SPEED_FOR_LIFT);
     //double turnSpeed = Robot.m_oi.liftController.getTwist();

     Robot.m_liftSubsystem.LiftArcade(MoveSpeed, RotateSpeed);
  }

  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    /// Robot.m_liftSubsystem.LiftArcade(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

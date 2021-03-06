/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.Console;

import edu.wpi.cscore.UsbCamera;
import frc.robot.OI;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LiftSubsystem;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterTwo;
import jdk.jfr.Enabled;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.SerialPort;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // stuff from tutorial

  // declares some variables. some are null so we can make them constants later
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static Drivetrain m_drivetrain = null;
  public static Shooter m_shooter = null;
  public static ShooterTwo m_shooterTwo = null;
  public static LiftSubsystem m_liftSubsystem = null;

  public static byte[] data = new byte[1];
  public static SerialPort serialPort = new SerialPort(9600, SerialPort.Port.kMXP);
  private static int donce = 0;

  // cameras
  UsbCamera cameraOne = CameraServer.getInstance().startAutomaticCapture();
  UsbCamera cameraTwo = CameraServer.getInstance().startAutomaticCapture();

  public static OI m_oi;

  Command m_autonomousCommand;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // declares these as calls. saves a lot of time
    // do the oi LAST to avoid the "subsystem null" error
    // more stuff from tutorial. Port numbers go in "digital io"

    // define switches here
    m_drivetrain = new Drivetrain();
    m_shooter = new Shooter();
    m_shooterTwo = new ShooterTwo();
    m_liftSubsystem = new LiftSubsystem();

    m_oi = new OI();

    while (!DriverStation.getInstance().isDSAttached()) {
      continue;
    }
    if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
      data[0] = 1;
      serialPort.write(data, 1);
      System.out.println("red");
    } else {
      data[0] = 2;
      serialPort.write(data, 1);
      System.out.println("blue");
    }

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // m_drivetrain.setSafetyEnabled(true);

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

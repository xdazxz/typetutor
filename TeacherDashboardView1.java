/* TeacherDashboardView1
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * The home screen of the Teacher Dashboard
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView1 extends WallPaperPanel
{
  //instance variables
  private JFrame window;
  private FrameModel model;
  
  private JPanel componentsPanel = new JPanel(new GridBagLayout());
  private JLabel welcomeText = new JLabel("Welcome,");
  private JLabel nameText = new JLabel();
  private CustomButton classListButton = new CustomButton("Class List", 346, 70, 32);
  private CustomButton changePasswordButton = new CustomButton("Change Password", 346, 70, 32);
  private CustomButton logoutButton = new CustomButton("Logout", 346, 70, 32);
  
  private GridBagConstraints gbc = new GridBagConstraints();
  
  private Teacher loggedIn;
  //constructor
  public TeacherDashboardView1(FrameModel model, JFrame frame, Teacher user)
  { 
    super();
    this.window = frame;
    this.model = model;
    this.loggedIn=user;
    this.layoutView();
    this.registerControllers();
    this.update();
  }//end constructor
  
  //set the initial layout of the window
  private void layoutView()
  {
    //the welcome text
    welcomeText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 48f));  
    nameText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 48f));
    nameText.setText(this.loggedIn.getTeacherUsername());
    this.gbc.insets = new Insets(160,0,20,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 0;
    componentsPanel.add(welcomeText,gbc);
    this.gbc.insets = new Insets(0,0,20,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 1;
    componentsPanel.add(nameText, gbc);
    
    //the buttons
    this.gbc.insets = new Insets(0,0,10,0);
    this.gbc.gridx = 0;
    this.gbc.gridy = 2;
    componentsPanel.add(classListButton, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 3;
    componentsPanel.add(changePasswordButton, gbc);
    this.gbc.gridx = 0;
    this.gbc.gridy = 4;
    componentsPanel.add(logoutButton, gbc);
    
    //the window
    componentsPanel.setOpaque(false);
    this.add(componentsPanel);
    window.setContentPane(this);
    window.setTitle("Learning Mode");
    window.setSize(1366, 768);
    window.setVisible(true);
    
  }//end layoutView
  
  //registering the controllers
  private void registerControllers()
  {
    FrameSwitchController classListController = new FrameSwitchController(this.classListButton,this.model,"TeacherDashboard3");
    this.classListButton.addMouseListener(classListController);
    
    FrameSwitchController changePasswordController = new FrameSwitchController(this.changePasswordButton,this.model,"TeacherDashboard2");
    this.changePasswordButton.addMouseListener(changePasswordController);
    
    FrameSwitchController logoutController = new FrameSwitchController(this.logoutButton,this.model,"Logout");
    this.logoutButton.addMouseListener(logoutController);
  }//end registerControllers
  
  //updates the view
  private void update()
  {
    
  }//end update
  
}//ssalc

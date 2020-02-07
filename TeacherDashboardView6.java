/* TeacherDashboardView6
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * Shows options for the student
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView6 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;

 private Teacher teacher;
 private int studentIndex;
 private JPanel contentPane = new JPanel();
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel classListText = new JLabel("Class List");
 private JTextField name = new JTextField();
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton showPasswordButton = new CustomButton("   Show Password", 460, 55, 20);
 private CustomButton changePasswordButton = new CustomButton("   Change Password", 460, 55, 20);
 private CustomButton showProgressButton = new CustomButton("   Show Game Progress", 460, 55, 20);
 private CustomButton showStatsButton = new CustomButton("   Show User Stats", 460, 55, 20);

 private GridBagConstraints gbc = new GridBagConstraints();

 //constructor
 public TeacherDashboardView6(FrameModel model, JFrame frame, int studentIndex, Teacher loggedIn)
 {
  super();
  this.window = frame;
  this.model = model;
  this.teacher=loggedIn;
  this.studentIndex = studentIndex;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(this.studentNames);
  //this.classList.setSelectedIndex(this.studentIndex);
  this.scrollPane = new JScrollPane(this.classList);
  this.layoutView();
  this.registerControllers();
  this.update();
 }//end constructor

 //sets the initial layout of the view
 private void layoutView()
 {
  //the classList
  this.classListText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 

  this.gbc.insets = new Insets(70,0,0,1040);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(classListText,gbc);
  this.classList.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 25f));
  this.classList.setSelectionBackground(new Color(241, 248, 108));
  this.classList.setSelectionForeground(Color.BLACK);
  this.classList.setFixedCellHeight(50);
  this.classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  this.scrollPane.setPreferredSize(new Dimension(375,530));
  this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  this.gbc.insets = new Insets(20,0,0,860);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(scrollPane,gbc);
  
  this.name.setPreferredSize(new Dimension(new Dimension(460,55)));
  this.name.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));
  this.name.setEditable(false);
  this.name.setOpaque(false);
  this.name.setBorder(null);
  this.gbc.insets = new Insets(0,45,480,0);
  componentsPanel.add(name,gbc);
  
  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);

  this.showPasswordButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(25,45,350,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(showPasswordButton,gbc);

  this.changePasswordButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(0,45,205,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(changePasswordButton,gbc);

  this.showProgressButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(0,45,85,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(showProgressButton,gbc);

  this.showStatsButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(35,45,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(showStatsButton,gbc);

  //the window
  componentsPanel.setOpaque(false);
  this.add(componentsPanel);
  this.setBackground(new Color(56, 183, 255));
  window.setContentPane(this);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.setSize(1366, 768);

 }//end layoutView

 private void registerControllers()
 {
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard3");
  this.backButton.addMouseListener(backController);
  
  FrameSwitchController showPasswordController = new FrameSwitchController(this.showPasswordButton,this.model,"TeacherDashboard7", this.studentIndex);
  this.showPasswordButton.addMouseListener(showPasswordController);
  
  FrameSwitchController changePasswordController = new FrameSwitchController(this.changePasswordButton,this.model,"TeacherDashboard8", this.studentIndex);
  this.changePasswordButton.addMouseListener(changePasswordController);
  
  FrameSwitchController showProgressController = new FrameSwitchController(this.showProgressButton,this.model,"TeacherDashboard9", this.studentIndex);
  this.showProgressButton.addMouseListener(showProgressController);
  
  FrameSwitchController showStatsController = new FrameSwitchController(this.showStatsButton,this.model,"TeacherDashboard10", this.studentIndex);
  this.showStatsButton.addMouseListener(showStatsController);
  
  SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard6");
  this.classList.addListSelectionListener(studentSelectionController);

 }//end registerControllers
 
 //updates the view
 public void update()
 {
  this.name.setText(this.studentNames[this.studentIndex]);
  
 }//end update

}//ssalc

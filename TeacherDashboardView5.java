/* TeacherDashboardView5
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * Removing a student from the student list
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView5 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;

 private Teacher teacher;
 private int studentIndex;
 private JPanel contentPane = new JPanel();
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel classListText = new JLabel("Class List");
 private JLabel prompt = new JLabel("Select a student to remove");
 private JTextField removePrompt = new JTextField();
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton confirmButton = new CustomButton("Confirm", 160, 60, 30);

 private GridBagConstraints gbc = new GridBagConstraints();

 //constructor
 public TeacherDashboardView5(FrameModel model, JFrame frame, int studentIndex, Teacher loggedIn)
 {
  super();
  this.window = frame;
  this.model = model;
  this.teacher=loggedIn;
  this.studentIndex = studentIndex;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(this.studentNames);
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

  //the buttons
  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);

  this.gbc.insets = new Insets(0,0,100,245);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(confirmButton, gbc);

  //the text
  this.prompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 32f));
  this.gbc.insets = new Insets(0,0,480,30);
  componentsPanel.add(prompt,gbc);

  this.removePrompt.setPreferredSize(new Dimension(new Dimension(460,55)));
  this.removePrompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 21f));
  this.removePrompt.setEditable(false);
  this.removePrompt.setOpaque(false);
  this.removePrompt.setBorder(null);
  this.gbc.insets = new Insets(0,55,200,0);
  componentsPanel.add(removePrompt,gbc);

  //the window
  componentsPanel.setOpaque(false);
  this.add(componentsPanel);
  this.setBackground(new Color(56, 183, 255));
  window.setContentPane(this);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.setSize(1366, 768);

 }//end layoutView

 //registering controllers
 private void registerControllers()
 {
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard3");
  this.backButton.addMouseListener(backController);
  
  SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard5");
  this.classList.addListSelectionListener(studentSelectionController);

  RemoveController removeController = new RemoveController(this.confirmButton,this.model,this.studentNames[this.studentIndex],this.teacher);
this.confirmButton.addMouseListener(removeController);
 }//registerControllers

 //updates the view
 private void update()
 {
  this.removePrompt.setText("Remove " + this.studentNames[this.studentIndex] + "?");
 }//end update
 
}//ssalc

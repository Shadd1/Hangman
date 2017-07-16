
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstWindow extends JFrame implements ActionListener {

  //main panel
  private JPanel panel;
  //category
  private JLabel categoryL;
  private JComboBox categoryCB;
  //level
  private JLabel levelL;
  private JRadioButton easyRB;
  private JRadioButton mediumRB;
  private JRadioButton hardRB;
  //buttons
  private JButton startGame;
  private JButton exitGame;

  public FirstWindow() {
    super("HangMan Game");
    setSize(320, 180);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    addComponents();
  }

  private void addComponents() {
    panel = new JPanel(null); // set layout to null - free layout
    //category label
    categoryL = new JLabel("Game Category :");
    categoryL.setBounds(10, 10, 100, 25); // set it's place
    panel.add(categoryL);
    // combobox for game category
    categoryCB = new JComboBox(new Object[]{"", "Sports", "Movies", "Food", "Countries"});
    categoryCB.setBounds(120, 10, 155, 25);// set it's place
    panel.add(categoryCB);
    //level label
    levelL = new JLabel("Choose Level:");
    levelL.setBounds(10, 50, 100, 25);// set it's place
    panel.add(levelL);
    // radio buttons for levels
    easyRB = new JRadioButton("Easy");
    easyRB.setBounds(100, 50, 55, 25);// set it's place
    easyRB.setSelected(true); // set default selected level
    mediumRB = new JRadioButton("Medium");
    mediumRB.setBounds(155, 50, 70, 25);// set it's place
    hardRB = new JRadioButton("Hard");
    hardRB.setBounds(225, 50, 70, 25);// set it's place
    ButtonGroup BG = new ButtonGroup(); //used to but all radiobuttons in (single selectection)
    BG.add(easyRB);
    BG.add(mediumRB);
    BG.add(hardRB);
    panel.add(easyRB);
    panel.add(mediumRB);
    panel.add(hardRB);
    // start and exit buttons
    startGame = new JButton("Start");
    startGame.addActionListener(this);// add action when button is pressed
    startGame.setBounds(50, 100, 80, 25);// set it's place
    panel.add(startGame);
    exitGame = new JButton("Exit");
    exitGame.addActionListener(this); // add action when button is pressed
    exitGame.setBounds(170, 100, 80, 25);// set it's place
    panel.add(exitGame);
    // add panel in center of frame
    add(panel, BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton pressed = (JButton) e.getSource(); // get pressed button
    if (pressed == exitGame)
      System.exit(0); // terminate game
    //otherwise - lets start the game
    int category = categoryCB.getSelectedIndex();
    if (category == 0) // no category selected
      JOptionPane.showMessageDialog(this, "Please select category!!");
    else { // let's start game
      int level;
      if (easyRB.isSelected()) // if easy
        level = 1;
      else if (mediumRB.isSelected()) // if medium
        level = 2;
      else // if hard
        level = 3;
      this.setVisible(false); // remove this frame
      new HangManGUI(category, level); // lets start the game
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new FirstWindow();
      }
    });
  }
}

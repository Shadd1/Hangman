
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HangManGUI extends JFrame implements ActionListener {

  //main contianer
  private JPanel panel;
  // labels
  private JLabel wordL; // display label on frame
  private JLabel letterL; // just a message
  private JLabel result; // display result - correct or wrong
  private JLabel guessesLeft; // display guesses left for user
  // test field for user guesses
  private JTextField letterTF;
  //button to check guess
  private JButton play;
  //button for play agian
  private JButton playAgain;
  //text area to display hanged man
  private JTextArea hangman;
  // counter for guesses
  private int counter = 6;
  // used to encrypt word
  private StringBuffer displayWord = new StringBuffer();
  // the word user going to guess
  private String randomWord;

  /**
   * two-argument constructor
   *
   * @param category word type
   * @param level easy, medium or hard
   */
  public HangManGUI(int category, int level) {
    super("Let's play HANGMAN!"); // header
    setSize(350, 300); // size
    setResizable(false); // can't change size
    setVisible(true); // make visible
    setLocationRelativeTo(null); // center screen
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout()); // layout as (NORTH - CENTER - SOUTH - EAST - WEST)
    addComponents(); // add frame components
    gameSetup(category, level); // game logic
  }

  /**
   * add components to frame
   */
  private void addComponents() {
    panel = new JPanel(null);
    // enter label
    letterL = new JLabel("Enter letter:");
    letterL.setBounds(10, 10, 100, 25);
    letterL.setFont(new Font("SansSerif", Font.BOLD, 15));
    panel.add(letterL);
    // text field for user guesses
    letterTF = new JTextField(3);
    letterTF.setBounds(120, 10, 30, 25);
    letterTF.setBackground(Color.LIGHT_GRAY);
    letterTF.setFont(new Font("SansSerif", Font.BOLD, 15));
    panel.add(letterTF);
    // button for check geuss
    play = new JButton("GO");
    play.setBounds(180, 10, 70, 25);
    play.addActionListener(this);
    panel.add(play);
    // result for guess - correct or wrong and display guessesleft
    result = new JLabel();
    result.setBounds(10, 80, 200, 25);
    panel.add(result);
    guessesLeft = new JLabel();
    guessesLeft.setBounds(10, 100, 100, 25);
    panel.add(guessesLeft);
    // text area for displaying hanged man
    hangman = new JTextArea(Hangs.Hang1());
    hangman.setBounds(190, 65, 120, 190);
    hangman.setFont(new Font("SansSerif", Font.BOLD, 18));
    hangman.setEnabled(false);
    panel.add(hangman);
    // play again button
    playAgain = new JButton("Play again");
    playAgain.setBounds(10, 230, 120, 25);
    playAgain.addActionListener(this);
    playAgain.setEnabled(false); // not enabled until game ends
    panel.add(playAgain);
    // place container on frame
    panel.setBackground(Color.white); // make background of window white
    add(panel, BorderLayout.CENTER);
  }

  /**
   * let's make game logic
   *
   * @param category word type
   * @param level easy, medium or hard
   */
  private void gameSetup(int category, int level) {
    Word word = null;
    if (category == 1) { // sport randomWord
      word = new Sports(level); // start game with level type
      word.generateWord(); // generate random word from list of words at choosed level
    }
    else if (category == 2) { // movie randomWord
      word = new Movies(level);// start game with level type
      word.generateWord();// generate random word from list of words at choosed level
    }
    else if (category == 3) { // food randomWord
      word = new Food(level);// start game with level type
      word.generateWord();
    }
    else if (category == 4) { // country randomWord
      word = new Countries(level);// start game with level type
      word.generateWord();// generate random word from list of words at choosed level
    }
    playGame(word);
  }

  /**
   * lets start game, complete some game logic
   */
  private void playGame(Word word) {
    randomWord = word.getWord(); // get random word for choosed level and choosed category
    //let's encrypt word
    for (int i = 0; i < randomWord.length(); i++)
      displayWord = displayWord.append("_");
    int index = randomWord.indexOf(" "); // get space in word
    // let's replace spaces in word
    while (index >= 0) {
      displayWord.setCharAt(index, ' ');
      index = randomWord.indexOf(" ", index + 1);// Start searching for next word if exist
    }
    //label for displaying word so far
    wordL = new JLabel(displayWordSoFar());
    wordL.setBounds(10, 45, 340, 25);
    wordL.setFont(new Font("SansSerif", Font.BOLD, 12));
    panel.add(wordL);
  }

  /**
   * handle button presses
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    // if pressed button is playAgain
    if ((JButton) e.getSource() == playAgain) {
      this.setVisible(false); // hide old game
      this.dispose(); // terminate old game
      new FirstWindow(); // let's start a new game
    }
    //otherwise play button is pressed
    else {
      boolean checkGuess = false; // guess correct ?
      // make sure the tet field not empty
      if (!letterTF.getText().isEmpty()) {
        //get guess and convert to uppercase
        String randomWordletter = letterTF.getText().toUpperCase();
        // check if guess correct
        for (int i = 0; i < randomWord.length(); i++) { // iterate word
          if (randomWordletter.charAt(0) == randomWord.charAt(i)) { // if found a match for guess
            displayWord.setCharAt(i, randomWordletter.charAt(0)); // change this letter
            checkGuess = true; // correct guess
          }
        }
        if (checkGuess) { // if correct guess
          result.setText("Correct");
          letterTF.setText("");
          guessesLeft.setText(counter + " guesses left");
          wordL.setText(displayWordSoFar());
        }
        else { // if wrong guess
          counter--; // decrease player chances
          //if player lost
          if (counter == 0) {
            wordL.setText("You hanged the man. word is ");
            result.setText(randomWord);
            guessesLeft.setText("");
            hangman.setText(Hangs.Hang7());
            play.setEnabled(false); // close button
            playAgain.setEnabled(true); // you want to play again ?
            letterTF.setEnabled(false); // close text
          }
          else { // still have some guesses
            result.setText("Wrong");
            guessesLeft.setText(counter + " guesses left");
            letterTF.setText("");
          }
        }
        checkGuess = false; // set to default to guess agian
        //if player wins
        if ((displayWord.toString()).equals(randomWord)) {
          wordL.setText("You guessed the word!!!!!");
          result.setText(randomWord);
          guessesLeft.setText("");
          letterTF.setEnabled(false); // close text field
          play.setEnabled(false); // close button
          playAgain.setEnabled(true); // you want to play again ?
          counter = 0;
        }
        //show hangman
        if (counter == 6) // no wrong guesses
          hangman.setText(Hangs.Hang1());
        else if (counter == 5)  // no wrong guess
          hangman.setText(Hangs.Hang2());
        else if (counter == 4)  // 2 wrong guesses
          hangman.setText(Hangs.Hang3());
        else if (counter == 3)  // 3 wrong guesses
          hangman.setText(Hangs.Hang4());
        else if (counter == 2)  // 4 wrong guesses
          hangman.setText(Hangs.Hang5());
        else if (counter == 1)  // 5 wrong guesses
          hangman.setText(Hangs.Hang6());
      }
    }
  }

  /**
   * return String represent word so far (correct guesses in word included)
   */
  private String displayWordSoFar() {
    StringBuffer randomWordWord = new StringBuffer();
    for (char ch : displayWord.toString().toCharArray()) {
      if (ch == ' ')
        randomWordWord.append("   "); // space
      else
        randomWordWord.append(ch + "  "); // letter
    }
    return randomWordWord.toString();
  }
}


public class Movies extends Word {

  //easy words 4-7 letters
  private String[] easyWords = {"Aladdin", "Aliens", "Alexander", "CRASH",
    "UNKOWNEN", "TITANIC", "PAYBACK", "BLADE"};
  // medium words 8-12 letters
  private String[] mediumWords = {"THE AVENGERS", "THE HULK", "FIGHT CLUB",
    "TRANSPORTER", "AMERICAN PIE", "WOLVERINE", "THE PACIFIER", "SWORDFISH"};
  //hard words 12-25 letters
  private String[] hardWords = {"LITTLE BLACK BOOK", "WOMAN IN BLACK",
    "TIME FOR CHANGE", "WILD WILD WEST", "PIRATES OF CARIBIAN",
    "A REASONABLE MAN", "LORD OF THE RING", "THEY CALL ME BRUCE"};

  public Movies(int level) {
    super(level);
  }

  @Override
  public void generateWord() {
    int option = (int) (Math.random() * 8);
    String word = "";
    switch (getLevel()) {
      case 1:
        word = easyWords[option];
        setWord(word);
        break;
      case 2:
        word = mediumWords[option];
        setWord(word);
        break;
      case 3:
        word = hardWords[option];
        setWord(word);
        break;

    }
  }
}

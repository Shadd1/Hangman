
public class Sports extends Word {

  //easy words 4-7 letters
  private String[] easyWords = {"KABADDI", "CHESS", "GOLF", "HOCKEY", "SOCCER", "FISHING",
    "DIVING", "BOXING"};
  // medium words 8-12 letters
  private String[] mediumWords = {"VOLLEYBALL", "ZHANG JIKE", "SWIMMING", "BASKETBALL",
    "AIR RACING", "AUTOCROSS", "FOOSBALL", "TAEKWONDO"};
  //hard words 12-25 letters
  private String[] hardWords = {"LIONEL MESSI", "SACHIN TENDULKAR", "RAHUL DRAVID",
    "VISHWANATAN ANAND", "TABLE TENNIS", "AMERICAN FOOTBALL", "BALLROOM DANCING",
    "BODY BUILDING"};

  public Sports(int level) {
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

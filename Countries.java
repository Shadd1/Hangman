
public class Countries extends Word {

  //easy words 4-7 letters
  private String[] easyWords = {"INDIA", "EGYPT", "MIAMI", "MOSCO", "JAMAICA"
  ,"CHINA","JAPAN","RUSSIA"};
  // medium words 8-12 letters
  private String[] mediumWords = {"MALAYSIA", "SAUDI ARABIA", "MADAGASCAR",
    "NEW ZEALAND", "NETHERLANDS", "MONTENEGRO", "MACEDONIA", "INDONESIA"};
  //hard words 12-25 letters
  private String[] hardWords = {"UNITED STATES", "CENTRAL AFRICAN REPUBLIC",
    "DEMOCRATIC REPUBLIC", "KINGDOM OF ENGLAND",
    "EQUATORIAL GUINEA", "FEDERATED OF MICRONESIA",
    "SOUTHWEST AFRICA", "PAPUA NEW GUINEA"};

  public Countries(int level) {
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

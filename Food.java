
public class Food extends Word {

  //easy words 4-7 letters
  private String[] easyWords = {"APPLE", "MEAT", "BACON", "BREAD", "EGGS", "HONEY",
    "FISH", "CORN"};
  // medium words 8-12 letters
  private String[] mediumWords = {"ASPARAGUS", "ALBACORE TUNA", "HAMBURGER",
    "ICE CREAM", "MEATBALLS", "PEPPERONI", "SPAGHETTI", "PANCAKES"};
  //hard words 12-25 letters
  private String[] hardWords = {"BABAGANOOSH", "CHIMICHANGA", "HUEVOS DIVORCIADOS",
    "PEANUT BUTTER", "SAUSAGE GRAVY", "SHUANGBAOTAI", "TAMAGO KAKE GOHAN", "VIENNOISERIE"};

  public Food(int level) {
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

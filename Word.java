
public abstract class Word implements WordInterface {

  private String word;
  private int level;

  public Word(int level) {
    this.level = level;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

}

package shop.ui;

public class UIFactory {
  private UIFactory() {}
  
//  static private UI _UI = new PopupUI();
  static private UI textUI = new TextUI();
  
  public static UI textUI() {
	    return new TextUI();
	  }
  
  public static UI popUI() {
	    return new PopupUI();
	  }
  
}

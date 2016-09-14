import java.util.ArrayList;
import java.util.List;

public class Cd {
  private String mArtist;
  private String mTitle;
  private static List<Cd> instances = new ArrayList<Cd>();
  private int mId;

  public Cd(String title, String artist) {
    mArtist = artist;
    mTitle = title;
    mId = instances.size();
    instances.add(this);
  }

  public String getArtist() {
    return mArtist;
  }

  public String getTitle() {
    return mTitle;
  }

  public int getId() {
    return mId;
  }

  public static void clear() {
    instances.clear();
  }

  public static List<Cd> all() {
    return instances;
  }

  public static Cd find(int id) {
    return instances.get(id);
  }

}

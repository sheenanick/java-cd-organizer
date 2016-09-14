import java.util.ArrayList;
import java.util.List;

public class Artist {
  private String mName;
  private static ArrayList<Artist> instances = new ArrayList<Artist>();
  private int mId;
  private List<Cd> mCds;

  public Artist(String name){
    mName = name;
    mId = instances.size();
    instances.add(this);
    mCds = new ArrayList<Cd>();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    if(instances.size() == 0){
      return null;
    }
   return instances;
  }

 public static void clear() {
   instances.clear();
 }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
    try {
      return instances.get(id);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public List<Cd> getCds() {
    if(mCds.size() == 0){
      return null;
    }
    return mCds;
  }

  public void addCd(Cd cd) {
    mCds.add(cd);
  }
}

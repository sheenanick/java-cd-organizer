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
   return instances;
  }

 public static void clear() {
   instances.clear();
 }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
   return instances.get(id);
 }

  public List<Cd> getCds() {
    return mCds;
  }

  public void addCd(Cd cd) {
    mCds.add(cd);
  }

}

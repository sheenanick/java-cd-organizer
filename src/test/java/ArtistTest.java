import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void Artist_instantiatesCorrectly_true() {
    Artist myArtist = new Artist("Radiohead");
    assertEquals(true, myArtist instanceof Artist);
  }

}

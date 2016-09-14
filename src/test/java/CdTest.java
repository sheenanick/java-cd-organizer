import org.junit.*;
import static org.junit.Assert.*;

public class CdTest {

  @Test
  public void Cd_instantiatesCorrectly_true() {
    Cd myCd = new Cd("Okay Computer", "Radiohead");
    assertEquals(true, myCd instanceof Cd);
  }

}


package InterCrud;
import modelo.*;
import java.util.*;

public interface medicinaDao {
    public void Adicion (medicina a);
    public void Modifica (medicina a);
    public void Anula (String cod);
    public medicina Busca (String cod);
    public List<medicina> lisMedi();
    
}

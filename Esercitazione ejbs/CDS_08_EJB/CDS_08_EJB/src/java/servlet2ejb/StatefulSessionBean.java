
package servlet2ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;


@Stateful //NB
public class StatefulSessionBean {

    private final List<String> notes = new ArrayList<String>();
    
    public String addAndRead(String inMsg) {
        notes.add(inMsg);
        String outMsg = "";
        for (String row: notes) {
            outMsg = outMsg+row+"\n";
        }
        return outMsg;
    }
}

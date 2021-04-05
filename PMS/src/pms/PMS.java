package pms;

import java.io.IOException;

/**
 *
 * @author Faraz Ahmad
 */
public class PMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //Admin.loadData();
        //Admin.loadItems();
        Login login = new Login();
        login.setVisible(true);
    }

}

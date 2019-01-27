/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */

import com.deltasi.presenze.model.User;
import com.deltasi.presenze.service.UserService;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;
public class daotest {
    
    public void TestUsers()
    {
        UserService s = new UserService();
       List<User> u= s.getAllUtenti();
       assertNotNull(u);
    }
}

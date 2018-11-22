package com.njbdqn.mysee;

import com.njbdqn.mysee.dao.ICardDAO;
import com.njbdqn.mysee.services.CardService;
import com.njbdqn.mysee.vo.Bankcards;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyseeApplicationTests {
    @Autowired
    private ICardDAO cardService;
    @Test
    public void contextLoads() {
        Bankcards bc = new Bankcards();
        bc.setUsername("h");
        for(int i=0;i<100;i++) {
            long time = System.currentTimeMillis();
            cardService.findCand(bc);
            System.out.println(System.currentTimeMillis() - time);
        }
    }

}

package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.model.GodsType;
import com.zking.logistics.basic.model.Goods;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BaseTest {
    protected Goods goods;

    @Before
    public void setUp(){
        goods=new Goods();
    }
}

package com.zking.logistics.basic.service.impService;

import com.zking.logistics.basic.model.GodsType;
import com.zking.logistics.basic.service.IGodsTypeService;
import com.zking.logistics.basic.service.IGoodsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GodsTypeServiceImplTest extends BaseTest{

    @Autowired
    private IGoodsService goodsService;

//    private GodsType godsType;

    @Test
    public void queryLstGoodType() {
        List<Map<String, Object>> maps = goodsService.queryGoodsPager(goods, null);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }

    }
}
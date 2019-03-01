package com.mycat.app.cusers;

import com.mycat.app.TestBase;
import com.mycat.app.entity.cuser.Cusers;
import com.mycat.app.service.cuser.CusersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @FileName: CusersServiceTest
 * @Author: <a href="dongann@aliyun.com">dongchang'an</a>.
 * @CreateTime: 2018/7/10 下午5:58
 * @Version: v1.0
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class CusersServiceTest extends TestBase {
    @Resource
    private CusersService cusersService;

    @Test
    public void testGetCuserByToken(){
        print(cusersService.getCuserByToken("wie8we82323847fd789238"));
    }


    @Test
    public void testGetCusersPageList(){
        print(cusersService.getCusersPageList(0,10));
    }


    @Test
    public void testSetCuserInfo(){
        Cusers cusers = new Cusers();
        cusers.setAccountId(0);
        cusers.setToken("33356we346hj74w4vt446");
        cusers.setCuserName("董长安");
        cusers.setCuserMobile("18354285412");
        print(cusersService.setCuserInfo(cusers));
    }
}

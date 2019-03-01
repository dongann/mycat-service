package com.mycat.app.serviceImpl.cuser;

import com.alibaba.dubbo.config.annotation.Service;
import com.mycat.app.common.ServiceResult;
import com.mycat.app.entity.cuser.Cusers;
import com.mycat.app.model.cuser.CuserModel;
import com.mycat.app.service.cuser.CusersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Service(version = "1.0.0", timeout = 3000)
@Component
public class CuersServiceImpl implements CusersService {
    private Logger log = LoggerFactory.getLogger(CuersServiceImpl.class);
    @Resource
    private CuserModel cuserModel;

    @Override
    public ServiceResult getCuserByToken(String token) {
        return ServiceResult.getSuccess("cuser",cuserModel.getCuserByToken(token));
    }

    /**
     * 分页获取用户列表
     * @param offset
     * @param length
     * @return
     */
    @Override
    public ServiceResult getCusersPageList(Integer offset, Integer length) {
        return ServiceResult.getSuccess(cuserModel.getCusersPageList(offset,length));
    }

    @Override
    public ServiceResult setCuserInfo(Cusers cusers) {
        return cuserModel.setCuserInfo(cusers);
    }

}

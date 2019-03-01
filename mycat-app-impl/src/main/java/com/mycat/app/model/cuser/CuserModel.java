package com.mycat.app.model.cuser;

import com.mycat.app.common.AppPaginationBean;
import com.mycat.app.common.ErrCodes;
import com.mycat.app.common.ServiceResult;
import com.mycat.app.dao.mall.read.cuser.CusersReadDAO;
import com.mycat.app.dao.mall.write.cuser.CusersWriteDAO;
import com.mycat.app.entity.cuser.Cusers;
import com.mycat.app.exception.BusinessException;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CuserModel {

    @Resource
    private CusersReadDAO cusersReadDAO;
    @Resource
    private CusersWriteDAO cusersWriteDAO;

    /**
     * 按token获取用户信息
     * @param token
     * @return
     */
    public Cusers getCuserByToken(@Param(value = "token") String token) {
        return cusersReadDAO.getByToken(token);
    }

    /**
     * 分页获取用户列表
     * @param offset
     * @param length
     * @return
     */
    public Map<String,Object> getCusersPageList(Integer offset, Integer length){
        Map<String,Object> resultMap = new HashMap<>();
        if(offset == null){
            throw new BusinessException(ErrCodes.PARAM_ERROR,"分页偏移量不能为空");
        }
        if(length == null || length.intValue() == 0){
            throw new BusinessException(ErrCodes.PARAM_ERROR,"分页长度不能为空或者0");
        }
        List<Cusers> cusersList = cusersReadDAO.getCusersPageList(offset,length+1);
        AppPaginationBean appPaginationBean = new AppPaginationBean(cusersList, length);
        resultMap.put("cuserList", appPaginationBean.getProcessedList());
        resultMap.put("hasMore", appPaginationBean.isHasMore());
        return resultMap;
    }

    /**
     * 设置用户信息
     * @param cusers 用户信息
     */
    public ServiceResult setCuserInfo(Cusers cusers){
        cusersWriteDAO.insertCusers(cusers);
        return ServiceResult.getSuccess();
    }

}

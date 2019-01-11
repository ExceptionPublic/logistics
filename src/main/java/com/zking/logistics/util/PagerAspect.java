package com.zking.logistics.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PagerAspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        PageBean pageBean=null;
        Object[] params = args.getArgs();
        for (Object param : params) {
            if (param instanceof PageBean) {
                pageBean=(PageBean) param;
                break;
            }
        }
        if (null!=pageBean && pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());

        Object proceed = args.proceed(params);

        if (null!=pageBean && pageBean.isPagination()){
            List list=(List) proceed;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }

        return proceed;
    }
}

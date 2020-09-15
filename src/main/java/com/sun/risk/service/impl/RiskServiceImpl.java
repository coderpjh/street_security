package com.sun.risk.service.impl;

import com.sun.risk.entity.Risk;
import com.sun.risk.mapper.RiskMapper;
import com.sun.risk.service.RiskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2020-09-15
 */
@Service
public class RiskServiceImpl extends ServiceImpl<RiskMapper, Risk> implements RiskService {

}

package com.sun.professor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.professor.entity.Professor;
import com.sun.professor.mapper.ProfessorMapper;
import com.sun.professor.service.ProfessorService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunql
 * @since 2020-09-11
 */
@Service
public class ProfessorServiceImpl extends ServiceImpl<ProfessorMapper, Professor> implements ProfessorService {

}

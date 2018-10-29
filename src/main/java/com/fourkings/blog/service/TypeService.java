package com.fourkings.blog.service;


import com.fourkings.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

//定义增删改和分页的接口
public interface TypeService  {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

}

package com.example.telepardaz.controllers;

import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.mappers.BaseMapper;
import com.example.telepardaz.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Transactional(readOnly = true)
public abstract class BaseController<E,D,S extends BaseService<? extends JpaRepository<E,Long>,E>> {
    @Autowired
    protected S service;
    @Autowired
    protected BaseMapper<D,E> mapper;

    @PostMapping
    @Transactional
    public void add(@RequestBody D e) throws ServiceException, NoSuchAlgorithmException, InvalidKeySpecException {
        service.add(mapper.convertDto(e));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody D e) throws ServiceException{
        service.update(mapper.convertDto(e));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removeById(@PathVariable("id") Long id) throws ServiceException{
        service.removeById(id);
    }

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) throws ServiceException{
       return mapper.convertEntity(service.findById(id).get());
    }

    @GetMapping
    public List<D> getAll() throws ServiceException{
        return mapper.convertEntity(service.getAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@RequestBody D e) throws ServiceException{
        return mapper.convertEntity(service.findByExample(mapper.convertDto(e)));
    }

}

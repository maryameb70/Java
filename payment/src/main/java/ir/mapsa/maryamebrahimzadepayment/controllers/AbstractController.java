package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.converters.BaseConverter;
import ir.mapsa.maryamebrahimzadepayment.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional(readOnly = true)
public abstract class AbstractController<E,D> {
    @Autowired
    private AbstractService<? extends JpaRepository<E,Long>,E> service;
    @Autowired
    private BaseConverter<D,E> converter;

    @PostMapping
    public void add(@RequestBody D e) throws Exception{
        service.add(converter.convertDto(e));
    }

    @PutMapping
    public void update(@RequestBody D e) throws Exception{
        service.update(converter.convertDto(e));
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id) throws Exception{
        service.removeById(id);
    }

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") Long id) throws Exception{
       return converter.convertEntity(service.findById(id).get());
    }

    @GetMapping
    public List<D> getAll(){
        return converter.convertEntity(service.getAll());
    }

    @PostMapping("/search")
    public List<D> findByExample(@RequestBody D e){
        return converter.convertEntity(service.findByExample(converter.convertDto(e)));
    }

}

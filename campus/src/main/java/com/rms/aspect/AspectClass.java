package com.rms.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {

    public final Logger log = Logger.getLogger(AspectClass.class.getName());

    @After("execution(* getAll*(..))")
    public void adviceMethodAfterFindAll(JoinPoint jp) {
        log.info("Whole table has been read");
    }

    @After("execution(* find*(..))")
    public void adviceMethodAfterFindById(JoinPoint jp) {
        log.info("A single entry has been read");
    }

    @After("execution(* insert(..))")
    public void adviceMethodAfterInsert(JoinPoint jp){
        log.info("An entry has been inserted");
    }

    @After("execution(* update(..))")
    public void adviceMethodAfterUpdate(JoinPoint jp) {
        log.info("An entry has been updated");
    }
    
    @After("execution(* updateById(..))")
    public void adviceMethodAfterUpdateById(JoinPoint jp) {
        log.info("An entry has been updated by ID");
    }
    @After("execution(* delete(..))")
    public void adviceMethodAfterDelete(JoinPoint jp) {
        log.info("An entry has been deleted");
    }


    @After("execution(* deleteById(..))")
    public void adviceMethodAfterDeleteById(JoinPoint jp) {
        log.info("An entry has been deleted by ID");
    }

}
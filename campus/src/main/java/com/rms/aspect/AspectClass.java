package com.rms.aspect;

import com.rms.log.Log4J;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClass {

    @After("execution(* findAll(..))")
    public void adviceMethodAfterFindAll(JoinPoint jp) {
        Log4J.log.info("All entries have been read (findAll)");
    }

    @After("execution(* findById(..))")
    public void adviceMethodAfterFindById(JoinPoint jp) {
        Log4J.log.info("A single entry has been read (findById)");
    }

    @After("execution(* save(..))")
    public void adviceMethodAfterInsert(JoinPoint jp) {
        Log4J.log.info("A new entry has been inserted (insert)");
    }

    @After("execution(* update(..))")
    public void adviceMethodAfterUpdate(JoinPoint jp) {
        Log4J.log.info("an entry has been updated (update)");
    }

    @After("execution(* updateById(..))")
    public void adviceMethodAfterUpdateById(JoinPoint jp) {
        Log4J.log.info("an entry has been updated by ID (updateById)");
    }

    @After("execution(* delete(..))")
    public void adviceMethodAfterDelete(JoinPoint jp) {
        Log4J.log.info("An entry has been deleted (delete)");
    }

    @After("execution(* deleteById(..))")
    public void adviceMethodAfterDeleteById(JoinPoint jp) {
        Log4J.log.info("An entry has been deleted by ID (deleteById)");
    }

    

}
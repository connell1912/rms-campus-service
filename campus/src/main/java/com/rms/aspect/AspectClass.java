package com.rms.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/** 
 * @author 1912dec16 Java Fullstack Batch 
 * <br>
 * <br>
 * The AspectClass handles the scattering issue with our logger. This enables us to implement the logger
 * after certain controller methods are called and is achieved by using the point cut expression and JoinPoints. 
 * The After annotation is used so that the logger will log information after these methods.
 */
@Component
@Aspect
public class AspectClass {

    private Logger log = Logger.getLogger(AspectClass.class.getName());

    @After("execution(* findAll(..))")
    public void adviceMethodAfterFindAll(JoinPoint jp) {
        log.info("All entries have been read (findAll)");
    }

    @After("execution(* findById(..))")
    public void adviceMethodAfterFindById(JoinPoint jp) {
        log.info("A single entry has been read (findById)");
    }

    @After("execution(* save(..))")
    public void adviceMethodAfterInsert(JoinPoint jp) {
        log.info("A new entry has been inserted (insert)");
    }

    @After("execution(* update(..))")
    public void adviceMethodAfterUpdate(JoinPoint jp) {
        log.info("an entry has been updated (update)");
    }

    @After("execution(* updateById(..))")
    public void adviceMethodAfterUpdateById(JoinPoint jp) {
        log.info("an entry has been updated by ID (updateById)");
    }

    @After("execution(* delete(..))")
    public void adviceMethodAfterDelete(JoinPoint jp) {
        log.info("An entry has been deleted (delete)");
    }

    @After("execution(* deleteById(..))")
    public void adviceMethodAfterDeleteById(JoinPoint jp) {
        log.info("An entry has been deleted by ID (deleteById)");
    }

    

}
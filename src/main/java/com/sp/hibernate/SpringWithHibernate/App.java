package com.sp.hibernate.SpringWithHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sp.beans.Account;
import com.sp.dao.AccountDao;
import com.sp.dao.AccountDaoImpl;
import com.sp.resources.JavaConfigFile;

public class App {

    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigFile.class);
        AccountDaoImpl accountDao = context.getBean(AccountDaoImpl.class);

        Account acc = new Account();
        acc.setAcc_num(1);
        acc.setFirst_name("K");
        acc.setLast_name("L");
        acc.setBalance(100000L);
        acc.setCity("New York");

        accountDao.createAccount(acc);
    }
}

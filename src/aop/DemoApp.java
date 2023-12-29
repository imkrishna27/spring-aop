package aop;

import aop.config.JavaSideConfig;
import aop.dao.AccountDao;
import aop.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class DemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaSideConfig.class);
        AccountDao accountDAO = annotationConfigApplicationContext.getBean("accountDao", AccountDao.class);
        MemberDao memberDao = annotationConfigApplicationContext.getBean("memberDao", MemberDao.class);
        accountDAO.addAccount();
        accountDAO.throwException();
        memberDao.addAccount();
        annotationConfigApplicationContext.close();
    }
}

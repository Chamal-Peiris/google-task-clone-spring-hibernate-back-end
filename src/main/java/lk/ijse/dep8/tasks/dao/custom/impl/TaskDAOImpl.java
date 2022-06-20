package lk.ijse.dep8.tasks.dao.custom.impl;

import lk.ijse.dep8.tasks.dao.CrudDAOImpl;
import lk.ijse.dep8.tasks.dao.custom.TaskDAO;
import lk.ijse.dep8.tasks.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Scope("prototype")
@Repository
public class TaskDAOImpl extends CrudDAOImpl<Task, Integer> implements TaskDAO {

    public TaskDAOImpl(SessionFactory session) {
        this.session = session;
    }
}

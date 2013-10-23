package br.com.semeru.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateDAO<T> implements InterfaceDAO<Object>, Serializable {

    private static final long serialVersionUID = 1L;
    private Class<T> classe;
    private Session session;

    public HibernateDAO(Class<T> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(Object entity) {
        session.save(entity);
    }

    @Override
    public void update(Object entity) {
        session.update(entity);
    }

    @Override
    public void remove(Object entity) {
        session.delete(entity);
    }

    @Override
    public void merge(Object entity) {
        session.merge(entity);
    }

    @Override
    public Object getEntity(Serializable id) {
        T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public Object getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<Object> getEntities() {        
        List<Object> entities = (List<Object>) session.createCriteria(classe).list();
        return entities;
    }

    @Override
    public List<Object> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }

}

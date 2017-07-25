package DAO;

import entities.Admin;

/**
 * Created by prajapas on 7/13/2017.
 */
public interface AdminDao {
    public boolean validate(Admin a);
    public boolean addAdmin(Admin a);
}

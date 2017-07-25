package DAO;

import entities.Operator;

import java.security.SecureRandom;
import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public interface OperatorDao {
    public List<Operator> getAllOperators();
    public boolean addOpertor(Operator o);
    public boolean blockOperator(String username);
    public boolean validate(String username, String password);
}

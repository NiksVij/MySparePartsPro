package DAO;

import entities.SpareParts;
import entities.Vehicle;

import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public interface SparePartsDao {
    public List<SpareParts> getAllSpareParts();
    public boolean addSparePart(SpareParts sparePart);
    public boolean removeSpareParts(SpareParts id, int number);
    public SpareParts findSparePart(String sparePartId);
}

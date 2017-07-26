package DAO;

import entities.SpareParts;
import entities.Vehicle;

import java.util.List;


public interface SparePartsDao {
     List<SpareParts> getAllSpareParts();
     boolean addSparePart(SpareParts sparePart);
      boolean removeSpareParts(String id/*, int number*/);
     SpareParts findSparePart(String sparePartId);
}

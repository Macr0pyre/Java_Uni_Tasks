package org.structure.dal.interfaces;

import org.structure.models.MedicalCard;

import java.util.List;

public interface MedicalCardDAO {
    MedicalCard get(long id);

    List<MedicalCard> getAll();

    void add(MedicalCard userCard);

    void update(MedicalCard userCard);

    void delete(long id);
}

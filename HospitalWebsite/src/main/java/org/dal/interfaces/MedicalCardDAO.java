package org.dal.interfaces;

import org.models.MedicalCard;

import java.util.List;

public interface MedicalCardDAO {
    MedicalCard get(long id);

    List<MedicalCard> getAll();

    void add(MedicalCard userCard);

    void update(MedicalCard userCard);

    void delete(long id);
}

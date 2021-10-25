package org.structure.dal.interfaces;

import org.structure.models.Registration;

import java.util.List;

public interface RegistrationDAO {
    Registration get(long id);

    List<Registration> getAll();

    void add(Registration registration);

    void update(Registration registration);

    void delete(long id);
}

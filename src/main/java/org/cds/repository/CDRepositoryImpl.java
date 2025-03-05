package org.cds.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.cds.entities.CD;

import java.util.List;

@ApplicationScoped
public class CDRepositoryImpl implements CDRepository {

    @Override
    public List<CD> listAllByBandaName(Sort sort) {
        PanacheQuery<CD> query = find("SELECT c FROM CD c JOIN c.banda b", sort);
        return query.list();
    }
}

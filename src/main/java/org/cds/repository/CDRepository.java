package org.cds.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import org.cds.entities.CD;

import java.util.List;

public interface CDRepository extends PanacheRepositoryBase<CD, Long> {
    List<CD> listAllByBandaName(Sort sort);
}
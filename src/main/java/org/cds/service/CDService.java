package org.cds.service;

import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.cds.entities.CD;
import org.cds.repository.CDRepository;

import java.util.List;

@ApplicationScoped
public class CDService {

    @Inject
    CDRepository cdRepository;

    public List<CD> listAll() {
        return cdRepository.listAll();
    }

    public CD getById(Long id) {
        return cdRepository.findById(id);
    }

    @Transactional
    public CD create(CD cd) {
        cdRepository.persist(cd);
        return cd;
    }

    @Transactional
    public CD update(Long id, CD cd) {
        CD entity = cdRepository.findById(id);
        if (entity == null) {
            return null;
        }
        cd.codigoCD = id;
        cdRepository.persist(cd);
        return cd;
    }

    @Transactional
    public boolean delete(Long id) {
        CD entity = cdRepository.findById(id);
        if (entity == null) {
            return false;
        }
        cdRepository.delete(entity);
        return true;
    }

    public List<CD> listAllByBanda(String banda) {
        return cdRepository.find("banda.nomeBanda", banda).list();
    }

    public List<CD> listByGravadora(String gravadora) {
        return cdRepository.find("gravadora.nomeGravadora", gravadora).list();
    }
}
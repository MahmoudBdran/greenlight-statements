package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.models.Unit;
import com.mbsystems.greenlight_statements.repository.OwnerRepository;
import com.mbsystems.greenlight_statements.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit saveUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit getUnitById(Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
    }
}


package com.mbsystems.greenlight_statements.controllers;

import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.models.Unit;
import com.mbsystems.greenlight_statements.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @PostMapping
    public Unit addUnit(@RequestBody Unit unit) {
        return unitService.saveUnit(unit);
    }

    @GetMapping("/{id}")
    public Unit getUnitById(@PathVariable Long id) {
        return unitService.getUnitById(id);
    }
}

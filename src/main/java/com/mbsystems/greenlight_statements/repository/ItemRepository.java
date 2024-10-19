package com.mbsystems.greenlight_statements.repository;

import com.mbsystems.greenlight_statements.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}

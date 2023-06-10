package com.ifdevs.ace.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifdevs.ace.model.entities.ReportHistory;

public interface ReportHistoryRepository extends JpaRepository<ReportHistory, UUID> {

}

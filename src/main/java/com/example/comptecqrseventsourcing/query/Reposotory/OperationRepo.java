package com.example.comptecqrseventsourcing.query.Reposotory;

import com.example.comptecqrseventsourcing.query.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation,Long> {
}

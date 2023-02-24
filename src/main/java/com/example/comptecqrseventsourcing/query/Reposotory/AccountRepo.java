package com.example.comptecqrseventsourcing.query.Reposotory;

import com.example.comptecqrseventsourcing.query.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}

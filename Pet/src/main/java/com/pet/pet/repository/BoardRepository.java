package com.pet.pet.repository;

import com.pet.pet.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findById(int id);
}

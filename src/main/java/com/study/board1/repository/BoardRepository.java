package com.study.board1.repository;

import com.study.board1.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}


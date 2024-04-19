package fr.fms.dao;

import fr.fms.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findByArticleId(Long articleId);
}
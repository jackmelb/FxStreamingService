/*
package com.jz.fx.streaming.service.core.repository;

import com.jz.fx.streaming.service.core.model.CcyPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

*/
/**
 * Created by Jack on 13/11/2017.
 *//*

@Repository
public interface FxPricesRepository extends JpaRepository<CcyPrices, Long>{

    @Query("select cp from CcyPrices cp where cp.Bid = :bid")
    List<CcyPrices> findByPrice(@Param("bid")Double bid);
}
*/

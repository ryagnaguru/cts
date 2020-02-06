package com.ygr.cts.service;

import com.ygr.cts.domain.ConductInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yagnaguru.r
 */

@Repository
public interface ConductInfoRepository extends CrudRepository<ConductInfo, Long> {
    @Query("select conduct from ConductInfo conduct where conduct.conductInfoId = : conductInfoId and conduct.deleted = 0")
    ConductInfo findByConductInfoId(Long conductInfoId);

    @Modifying
    @Query("update ConductInfo u set u.deleted = 1 where u.conductInfoId = :conductInfoId")
    void deleteByConductInfoId(Long conductInfoId);
}
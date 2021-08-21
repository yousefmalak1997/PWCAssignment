package com.pwc.complaintmanagementportal.complaint;

import com.pwc.complaintmanagementportal.uses.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaints,Long> {

    Optional<List<Complaints>> findByCreatorId(Long id);

    Complaints findBycId(Long id);

    @Modifying
    @Query("UPDATE Complaints c " +
            "SET c.dateUpdated = ?2 , complaintsStatus = ?3 WHERE c.cId = ?1")
    void updateById(Long comId, LocalDateTime localDateTime, ComplaintsStats complaintsStats);
}

package com.uv.trial.Recommendation.Repository;

import com.uv.trial.Recommendation.Model.UserHistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistoryDTO,Integer>
{
    @Query("select uh.sizeId from UserHistoryDTO uh where uh.userId = ?1 and uh.categoryId=?2")
    Integer getHistory(@Param("userId") int userId,@Param("categoryId")int categoryId);

}

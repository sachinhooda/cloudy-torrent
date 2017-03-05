package com.sachin.cloudy.data.repositories;

import com.sachin.cloudy.data.entities.DataUsageStats;
import org.springframework.stereotype.Repository;

/**
 * Created by sachinhooda on 25/2/17.
 */
@Repository
public interface DataUsageStatsRepository extends BaseRepository<DataUsageStats, Long> {
}

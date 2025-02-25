package com.watanabefactory.repository.entity;

import java.time.OffsetDateTime;

public record WaterDailyUsage(Integer id, Integer amount, OffsetDateTime updatedAt) {
}

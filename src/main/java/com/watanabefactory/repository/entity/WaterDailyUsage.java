package com.watanabefactory.repository.entity;

import java.time.OffsetDateTime;

public record WaterDailyUsage(Integer amount, OffsetDateTime updatedAt) {}

package com.watanabefactory.repository.entity;

import java.time.OffsetDateTime;
import java.util.List;

public record WaterUsage(Integer amount, OffsetDateTime timestamp, List<WaterDailyUsage> waterDailyUsages) {}

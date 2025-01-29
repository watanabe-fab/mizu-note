insert into users (email, password, max_water_usage, created_at, updated_at, deleted_flag) values ('test@dummy.co.jp', 'test', 500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);

insert into water_usages (user_id, water_amount, created_at, updated_at, deleted_flag) values (1, 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);
insert into water_usages (user_id, water_amount, created_at, updated_at, deleted_flag) values (1, 150, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);

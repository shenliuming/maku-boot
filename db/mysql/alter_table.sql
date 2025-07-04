-- 2. 老师表 - 放在课程表前面更合理
CREATE TABLE `yoga_teacher` (
                             `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '老师ID',
                             `name` VARCHAR(20) NOT NULL COMMENT '姓名',
                             `phone` VARCHAR(15) NOT NULL COMMENT '手机号',
                             `avatar` VARCHAR(255) DEFAULT NULL COMMENT '头像',
                             `member_id` BIGINT DEFAULT NULL COMMENT '关联会员ID',
                             `status` TINYINT DEFAULT 1 COMMENT '状态 0:离职 1:在职',
                             `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             INDEX `idx_member` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '老师表';

-- 3. 课程表 (服务产品)
CREATE TABLE `yoga_course` (
                            `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '课程ID',
                            `name` VARCHAR(50) NOT NULL COMMENT '课程名称',
                            `type` TINYINT NOT NULL COMMENT '1-私教 2-小班 3-团课 4-精品课',
                            `duration` SMALLINT NOT NULL COMMENT '时长(分钟)',
                            `status` TINYINT DEFAULT 1 COMMENT '状态 0:禁用 1:启用',
                            `version` INT DEFAULT 0 COMMENT '版本号',
                            `deleted` TINYINT DEFAULT 0 COMMENT '删除标识 0:正常 1:已删除',
                            `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '课程表';

-- 4. 场地表 (物理空间)
CREATE TABLE `yoga_space` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '场地ID',
                           `name` VARCHAR(20) NOT NULL COMMENT '场地名称',
                           `capacity` SMALLINT NOT NULL COMMENT '容纳人数',
                           `status` TINYINT DEFAULT 1 COMMENT '状态 0:关闭 1:开放' -- 增加状态管理
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '场地表';

-- 5. 排期表 (核心运营表)
CREATE TABLE `yoga_schedule` (
                              `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '排期ID',
                              `course_id` BIGINT NOT NULL COMMENT '课程ID',
                              `teacher_id` BIGINT NOT NULL COMMENT '老师ID',
                              `space_id` BIGINT NOT NULL COMMENT '场地ID',
                              `start_time` DATETIME NOT NULL COMMENT '开始时间',
                              `end_time` DATETIME NOT NULL COMMENT '结束时间',
                              `max_seats` SMALLINT NOT NULL COMMENT '最大名额',
                              `booked_seats` SMALLINT DEFAULT 0 COMMENT '已预约数',
                              `status` TINYINT DEFAULT 1 COMMENT '1-可预约 2-已满 3-取消',
                              `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              INDEX `idx_time` (`start_time`, `end_time`) -- 时间索引加速查询
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '课程排期表';

-- 6. 预约表 (核心业务表)
CREATE TABLE `yoga_booking` (
                             `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '预约ID',
                             `member_id` BIGINT NOT NULL COMMENT '会员ID',
                             `schedule_id` BIGINT NOT NULL COMMENT '排期ID',
                             `status` TINYINT DEFAULT 1 COMMENT '1-预约中 2-已完成 3-已取消',
                             `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
                             UNIQUE KEY `uniq_member_schedule` (`member_id`, `schedule_id`)-- 防止重复预约
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '预约记录表';

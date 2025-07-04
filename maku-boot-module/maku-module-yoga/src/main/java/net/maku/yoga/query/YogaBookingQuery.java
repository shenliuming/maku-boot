package net.maku.yoga.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.*;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 预约记录表查询
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "预约记录表查询")
public class YogaBookingQuery extends Query {
}
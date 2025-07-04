package net.maku.yoga.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.*;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 课程表查询
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "课程表查询")
public class YogaCourseQuery extends Query {
}
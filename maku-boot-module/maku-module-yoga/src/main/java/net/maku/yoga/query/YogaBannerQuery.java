package net.maku.yoga.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.*;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 首页banner管理查询
 *
 * @author Sterling Shen ceekayshen@foxmail.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "首页banner管理查询")
public class YogaBannerQuery extends Query {
}
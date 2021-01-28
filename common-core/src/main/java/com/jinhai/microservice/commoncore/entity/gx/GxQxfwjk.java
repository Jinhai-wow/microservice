package com.jinhai.microservice.commoncore.entity.gx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName GxQxfwjk
 * @Author Jinhai
 * @Date 2020/10/20 16:34
 * @Version 1.0
 */
@Data
@TableName("gx_qxfw_jk")
public class GxQxfwjk {
    String id;

    String servicecode;

    String pqxdm;

    String pqxmc;

    String qxdm;

    String qxmc;

    String fwzt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date qqqssj;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date qqjssj;

    String bz;
}

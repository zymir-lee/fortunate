package pers.zymir.fortunate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
}

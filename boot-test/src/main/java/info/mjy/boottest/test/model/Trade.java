package info.mjy.boottest.test.model;

import info.mjy.boottest.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel(value = "Trade(销售)")
public class Trade extends BaseModel {

    /**
     * alias
     */
    public static final String TABLE_ALIAS = "Trade";
    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_VERSION = "VERSION";
    public static final String ALIAS_CREATETIME = "创建时间";
    public static final String ALIAS_LASTMODIFYTIME = "最后一次修改时间";
    public static final String ALIAS_SOURCESYS = "来源系统";
    public static final String ALIAS_PFDOCNO = "平台订单号";
    public static final String ALIAS_PFSOURCE = "平台来源";
    public static final String ALIAS_BUSCODE = "业务部门编码";
    public static final String ALIAS_BUSNAME = "业务部门名称";
    public static final String ALIAS_PFORDERTIME = "平台下单时间";
    public static final String ALIAS_PFPAYTIME = "付款时间";
    private static final long serialVersionUID = 4201631085787117585L;

    //columns START
//    @ApiModelProperty(value = ALIAS_ID, required = true)
//    private ObjectsId id;

    @ApiModelProperty(value = ALIAS_VERSION, required = true)
    private Integer version;

    @ApiModelProperty(value = ALIAS_CREATETIME, required = true)
    private Date createTime;

    @ApiModelProperty(value = ALIAS_LASTMODIFYTIME, required = true)
    private Date lastModifyTime;

    @ApiModelProperty(value = ALIAS_SOURCESYS, required = true)
    private String sourceSys;

    @NotNull
    @ApiModelProperty(value = ALIAS_PFDOCNO, required = true)
    private String pfDocNo;

    @ApiModelProperty(value = ALIAS_PFSOURCE)
    private String pfSource;

    @ApiModelProperty(value = ALIAS_BUSCODE, required = true)
    private String busCode;

    @ApiModelProperty(value = ALIAS_BUSNAME, required = true)
    private String busName;

    @ApiModelProperty(value = ALIAS_PFORDERTIME)
    private Date pfOrderTime;

    @ApiModelProperty(value = ALIAS_PFPAYTIME, required = true)
    private Date pfPayTime;

}
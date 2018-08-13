package info.mjy.boottest.test.model;

import info.mjy.boottest.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "TradeItem(销售明细)")
public class TradeItem extends BaseModel {

    /**
     * alias
     */
    public static final String TABLE_ALIAS = "TradeItem";
    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_LINETYPE = "物料类型";
    public static final String ALIAS_PFITEMID = "平台行ID";
    public static final String ALIAS_SKUCODE = "SKU编码";
    public static final String ALIAS_BRANDSKUCODE = "品牌方SKU编码";
    public static final String ALIAS_BARCODE = "条码";
    public static final String ALIAS_ARTNO = "货号";
    public static final String ALIAS_PFSKUNAME = "平台商品名称";
    public static final String ALIAS_QTY = "商品数量";
    public static final String ALIAS_PRICE = "折后单价";
    public static final String ALIAS_TOTAL = "折后金额";

    private static final long serialVersionUID = -4879705367844156110L;

    //columns START
//    @ApiModelProperty(value = ALIAS_ID, required = true)
//    private ObjectsId id;

    @ApiModelProperty(value = ALIAS_LINETYPE, required = true)
    private String lineType;

    @ApiModelProperty(value = ALIAS_PFITEMID)
    private String pfItemId;

    @ApiModelProperty(value = ALIAS_SKUCODE)
    private String skuCode;

    @ApiModelProperty(value = ALIAS_BRANDSKUCODE)
    private String brandSkuCode;

    @ApiModelProperty(value = ALIAS_BARCODE)
    private String barCode;

    @ApiModelProperty(value = ALIAS_ARTNO)
    private String artNo;

    @ApiModelProperty(value = ALIAS_PFSKUNAME)
    private String pfSkuName;

    @ApiModelProperty(value = ALIAS_QTY)
    private Long qty;

    @ApiModelProperty(value = ALIAS_PRICE, required = true)
    private BigDecimal price;

    @ApiModelProperty(value = ALIAS_TOTAL, required = true)
    private BigDecimal total;

}
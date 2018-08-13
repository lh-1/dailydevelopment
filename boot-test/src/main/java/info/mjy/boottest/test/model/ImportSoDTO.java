package info.mjy.boottest.test.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "ImportSoDTO", description = "ImportSoDTO(销售)")
public class ImportSoDTO {

    @Valid
    @NotNull
    @ApiModelProperty(value = "Trade(销售)", required = true)
    private Trade trade;

    @Valid
    @NotNull
    @ApiModelProperty(value = "TradeItem(销售明细)", required = true)
    private TradeItem tradeItem;

}

package me.jcala.xmarket.server.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.jcala.xmarket.server.entity.dto.Result;
import me.jcala.xmarket.server.service.inter.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("跟学校有关的api")
@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {

    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @ApiOperation(value = "获取所有的商品分类",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = "tags/get",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainTradeTagList(int kind){

        if (kind==1){
            return tradeService.getTradeTagList();//kind为1返回TradeTag列表
        }else{
            return tradeService.getTradeTagNameList();//kind为2返回TradeTag列表
        }

    }


    @ApiOperation(value = "获取指定分类下的商品",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = "tags/{tagId}/get",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainTradeListByTag(@PathVariable("tagId") String tagId){

        return tradeService.getTradeListBySort(tagId);
    }


    @ApiOperation(value = "通过id获取商品的详细信息",response = Result.class,produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/{tradeId}/get",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> gainTradeDetailById(@PathVariable("tradeId") String tradeId){

        return null;
    }

}
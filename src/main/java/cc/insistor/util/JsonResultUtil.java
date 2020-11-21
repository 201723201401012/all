package cc.insistor.util;

import cc.insistor.constant.JsonResultCode;
import cc.insistor.model.vo.JsonResultVO;

/**
 * 统一接口返回工具类
 * @author cc
 */
public class JsonResultUtil {
    private JsonResultUtil() {
    }
    /**
     * 无数据成功返回
     *
     * @return
     */
    public static JsonResultVO success() {
        return success(null);
    }

    /**
     * 有数据成功返回
     *
     * @param data
     * @return
     */
    public static JsonResultVO success(Object data) {
        JsonResultCode jsonResultCode = JsonResultCode.SUCCESS;
        JsonResultVO jsonResultVO = new JsonResultVO();
        jsonResultVO.setCode(jsonResultCode.getCode());
        jsonResultVO.setMsg(jsonResultCode.getMsg());
        jsonResultVO.setSuccess(true);
        jsonResultVO.setData(data);
        return jsonResultVO;
    }

    /**
     * 默认失败返回
     *
     * @return
     */
    public static JsonResultVO failure() {
        JsonResultCode jsonResultCode = JsonResultCode.INTERNAL_SERVER_ERROR;
        return failure(jsonResultCode.getCode(), jsonResultCode.getMsg());
    }


    /**
     * 根据枚举返回
     *
     * @param jsonResultCode
     * @return
     */
    public static JsonResultVO failure(JsonResultCode jsonResultCode) {
        return failure(jsonResultCode.getCode(), jsonResultCode.getMsg());
    }


    /**
     * 异常返回
     *
     * @param e
     * @return
     */
    public static JsonResultVO failure(Exception e) {
        return failure("500", e.toString());
    }


    /**
     * 自定义错误说明返回
     *
     * @param msg
     * @return
     */
    public static JsonResultVO failure(String msg) {
        return failure("-1", msg);
    }

    /**
     * 自定义代码和错误说明返回
     *
     * @param code
     * @param msg
     * @return
     */
    public static JsonResultVO failure(String code, String msg) {
        JsonResultVO jsonResultVO = new JsonResultVO();
        jsonResultVO.setSuccess(false);
        jsonResultVO.setCode(code);
        jsonResultVO.setMsg(msg);
        return jsonResultVO;
    }






}

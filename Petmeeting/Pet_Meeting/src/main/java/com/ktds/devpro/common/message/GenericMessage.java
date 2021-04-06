package com.pm.common.message;

/**
 *
 * 요청에 대한 표준 응답 요청 메시지 포맷
 * <p>
 *
 * <pre>
 * 개정이력(Modification Information)·
 * 수정일   수정자    수정내용
 * ------------------------------------
 * 2017. 3. 16.   kt ds     최초작성
 * </pre>
 *
 * @author kt ds A.CoE(yu.chae@kt.com)
 * @since 2017. 3. 16.
 * @version 1.0.0
 * @see
 *
 */
public interface GenericMessage {

    /**
     * 정상
     */
    String OK = "OK";

    /**
     * 실패
     */
    String NG = "NG";

    void setOK();

    void setNG();

    void enableCustomeMessage();

    void setMessage(String message);

    void setData(Object data);

    void setReturnCode(String returnCode);
}

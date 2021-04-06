package com.pm.common.message;

/**
 *
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
public interface GenericMessageAssessor {

    boolean isCustomeMessage();

    Object getData();

    String getMessage();

    String getReturnCode();

    void transformMessage(LocaleAwareMessageService service);
}

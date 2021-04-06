package com.pm.common.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
/**
 *
 * Locale 정보에 따라 메시지를 조회한다
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
@Component
public class LocaleAwareMessageService {

    @Autowired
    private MessageSource messageSource;

    /**
     *
     * 코드값으로 메시지 조회
     *
     * @param code 코드명
     * @return 코드에 해당하는 값
     *
     */
    public String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    /**
     *
     * 코드값으로 메시지 조회, 코드값이 없으면 기본 메시지를 보여준다.
     *
     * @param code 코드명
     * @param defaultMessage 기본값
     * @return 코드에 해당하는 값
     *
     */
    public String getMessage(String code, String defaultMessage) {
        return messageSource.getMessage(code, null, defaultMessage, LocaleContextHolder.getLocale());
    }

    /**
     *
     * 코드값으로 메시지를 조회하고 치환할 내용을 함께 셋팅, 코드값이 없으면 기본 메시지를 보여준다.
     *
     * @param code 코드명
     * @param args 치환할 문자
     * @param defaultMessage 기본값
     * @return 코드에 해당하는 값
     *
     */
    public String getMessage(String code, String args, String defaultMessage) {
        return messageSource.getMessage(code, new String[]{args}, defaultMessage, LocaleContextHolder.getLocale());
    }

    /**
     *
     * 코드값으로 메시지를 조회하고 치환할 내용을 셋팅.
     *
     * @param code 코드명
     * @param args 치환할 문자배열
     * @return 코드에 해당하는 값
     *
     */
    public String getMessage(String code, String[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    /**
     *
     * 코드값으로 메시지를 조회하고 치환할 내용을 함께 셋팅, 코드값이 없으면 기본 메시지를 보여준다.
     *
     * @param code 코드명
     * @param args 치환할 문자배열
     * @param defaultMessage 기본값
     * @return 코드에 해당하는 값
     *
     */
    public String getMessage(String code, String[] args, String defaultMessage) {
        return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }

}

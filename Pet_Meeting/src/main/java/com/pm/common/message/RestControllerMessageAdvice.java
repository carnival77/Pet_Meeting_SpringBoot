package com.ktds.devpro.common.message;

import com.ktds.devpro.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/**
 *
 * RestControler에 적용되는 ControllerAdvice
 * BaseResponse로 message나 데이터를 wrapping하여 클라이언트에 전달하는 데이터 골격을 생성한다.
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

//FIXME: 이종혁 - 메시지로 감싸지 않고, 직접 넘기는 방식으로 개발함.. 예외 처리에 대해서도 검토해 볼 것 
@ControllerAdvice(annotations = RestController.class)
public class RestControllerMessageAdvice { //implements ResponseBodyAdvice<Object> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocaleAwareMessageService messageService;

    
    /*
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
    
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> messageConverter,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        GenericMessage message = null;

        if(body instanceof GenericMessage) {
            message = (GenericMessage) body;
        }else{
            message = (GenericMessage) RequestContextHolder.getRequestAttributes().getAttribute(Const.GENERIC_MESSAGE, RequestAttributes.SCOPE_REQUEST);
            if(body!=null){
                message.setData(body);
            }
        }

        // 공통 메시지 처리
        if(!((GenericMessageAssessor) message).isCustomeMessage()){
            ((GenericMessageAssessor) message).transformMessage(messageService);
        }

        // 리턴 데이터
        logger.debug("RestControllerMessageAdvice.beforeBodyWrite(): {}", ((RestMessage) message).toString());


        return message;
    }
    */

    /**
     * 기본 예외처리 헨들러, 다른 예외처리 헨들러에서 처리되지 않은 예외들을 처리함.
     * @param ex
     * @param request
     * @return
     */
    //FIXME: 살려야 함...
//    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestMessage> handleOtherExceptions(Exception ex, WebRequest request) {

        logger.debug("RestControllerMessageAdvice.handleOtherExceptions(): {}", ex);
  //      ex.printStackTrace();
        

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestMessage message = new RestMessage();
        message.setMessage(ex.getMessage());

        // 공통 메시지 처리
        if(!((GenericMessageAssessor) message).isCustomeMessage()){
            ((GenericMessageAssessor) message).transformMessage(messageService);
        }

        return new ResponseEntity<>(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

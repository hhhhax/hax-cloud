/*
 *
 *  *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  *  <p>
 *  *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *  <p>
 *  * https://www.gnu.org/licenses/lgpl.html
 *  *  <p>
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.hax.common.web.handler;

import com.hax.common.core.enums.GlobalErrorCodeConstants;
import com.hax.common.core.exception.GlobalException;
import com.hax.common.core.exception.ServiceException;
import com.hax.common.core.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;
import java.util.List;

import static com.hax.common.core.enums.GlobalErrorCodeConstants.*;

/**
 * @author hax
 * @date 2020/7/15 全局的的异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerResolver {


    /**
     * 处理 SpringMVC 请求参数缺失
     * <p>
     * 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
        return CommonResult.error(BAD_REQUEST.getCode(),
                String.format("请求参数缺失:%s", ex.getParameterName()));
    }


    /**
     * 处理 SpringMVC 请求方法不正确
     * <p>
     * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        log.warn("[httpRequestMethodNotSupportedExceptionHandler]", ex);
        return CommonResult.error(GlobalErrorCodeConstants.METHOD_NOT_ALLOWED.getCode(),
                String.format("请求方法不正确:%s", ex.getMessage()));
    }

    /**
     * 处理 SpringMVC 请求参数类型错误
     * <p>
     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
        return CommonResult.error(BAD_REQUEST.getCode(),
                String.format("请求参数类型错误:%s", ex.getMessage()));
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public CommonResult SocketTimeoutExceptionHandler(SocketTimeoutException e) {
        log.error("[socketTimeoutExceptionHandler]", e);
        return CommonResult.error(SOCKET_TIMEOUT_ERROR.getCode(), SOCKET_TIMEOUT_ERROR.getMessage());
    }

    // 逻辑异常
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(ServiceException ex) {
        log.debug("业务逻辑异常 ex={}", ex);
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理全局异常 ServiceException
     * <p>
     * 例如说，Dubbo 请求超时，调用的 Dubbo 服务系统异常
     */
    @ExceptionHandler(value = GlobalException.class)
    public CommonResult globalExceptionHandler(HttpServletRequest req, GlobalException ex) {
        // 系统异常时，才打印异常日志
        if (GlobalErrorCodeConstants.isMatchServiceError(ex.getCode())) {

            log.error("[globalExceptionHandler]", ex);
            //TODO 插入异常日志
            //      this.createExceptionLog(req, ex);
            // 普通全局异常，打印 info 日志即可
        } else {
            log.info("[globalExceptionHandler]", ex);
        }
        // 返回 ERROR CommonResult
        return CommonResult.error(ex);
    }

    /**
     * 全局异常.
     *
     * @param e the e
     * @return ResponseResult
     */
    @ExceptionHandler(Exception.class)
    public CommonResult exception(Exception e) {
        log.error("[defaultExceptionHandler]", e);
        // TODO 插入异常日志
        //    this.createExceptionLog(req, ex);
        // 返回 ERROR CommonResult
        return CommonResult.error(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.getMessage());
    }

    /**
     * validation Exception (以json形式传参)
     *
     * @param e
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult bodyValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String defaultMessage = fieldErrors.get(0).getDefaultMessage();
        log.warn("参数校验失败：{}", defaultMessage);
        return CommonResult.error(BAD_REQUEST.getCode(), BAD_REQUEST.getMessage() + ":" + defaultMessage);
    }

    /**
     * validation Exception (以form-data形式传参)
     *
     * @param exception
     * @return R
     */
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult bindExceptionHandler(BindException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String defaultMessage = fieldErrors.get(0).getDefaultMessage();
        log.warn("参数校验失败：{}", defaultMessage);
        return CommonResult.error(BAD_REQUEST.getCode(), BAD_REQUEST.getMessage() + ":" + defaultMessage);
    }

}

package jp.matrix.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public abstract class BaseAbstractController {

    /**
            * その他のExceptionの例外処理
     * @param e
     */

	@ExceptionHandler
    protected Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        log.error(e.getMessage() + e.getStackTrace());
        map.put("basecontroller", "error");
        return map;
    }
}

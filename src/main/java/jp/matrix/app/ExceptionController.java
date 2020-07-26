package jp.matrix.app;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class ExceptionController extends BaseAbstractController{

    @RequestMapping(value="/exception", method = RequestMethod.GET)
    public void exception() throws Exception {
        //throw new Exception();
    }

    /**
     * SQLExceptionの例外処理
     * @param e
     * @throws Exception
     */

	@ExceptionHandler(SQLException.class)
    private void sqlExceptionHandler(Exception e) {
    	log.error("SQLException Handler" + e.getStackTrace());
    	System.out.println("SQLException Handler" + e.getStackTrace());
        // throw e;してもexceptionHandlerにはいかない
    }

    /**
     * Runtime系の例外処理
     */

	@ExceptionHandler(RuntimeException.class)
    private void runtimeExceptionHandler(RuntimeException e) {
    	log.error("RuntimeException Handler" + e.getStackTrace());
        System.out.println("RuntimeException Handler" + e.getStackTrace());
    }

    /**
     * その他のException例外処理
     */

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @Override
    protected Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>();
        map.put("override", "error");
    	log.error("Exception Handler" + e.getStackTrace());
        System.out.println("Exception Handler" + e.getStackTrace());
        return map;
    }
}
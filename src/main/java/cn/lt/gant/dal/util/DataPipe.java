package cn.lt.gant.dal.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 数据通道,数据放入model通过内容协商处理器返回
 *
 * @author lt
 * @version 1.0
 */
public class DataPipe {

    private Map<String, Object> model;

    public DataPipe(Map<String, Object> model) {
        this.model = model;
    }

    public static DataPipe in(Model model) {
        return new DataPipe(model.asMap());
    }

    public static DataPipe in(ModelAndView model) {
        return new DataPipe(model.getModel());
    }

    public DataPipe response(Object response) {
        this.model.put("response", response);
        return this;
    }

    public DataPipe meta(int code) {
        Meta meta = (Meta) this.model.get("meta");
        if (meta == null) {
            this.model.put("meta", new Meta(code));
        } else {
            meta.code = code;
        }
        return this;
    }

    public DataPipe meta(int code, String message) {
        Meta meta = (Meta) this.model.get("meta");
        if (meta == null) {
            this.model.put("meta", new Meta(code, message));
        } else {
            meta.code = code;
            meta.message = message;
        }
        return this;

    }

    class Meta {
        private int code;
        private String message;

        public Meta(int code) {
            this.code = code;
        }

        public Meta(int code, String message) {
            this.code = code;
            this.message = message;
        }


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return this.code == 0 ? 200 : this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

    }
}

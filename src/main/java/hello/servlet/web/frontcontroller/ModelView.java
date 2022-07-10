package hello.servlet.web.frontcontroller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;



@Data
public class ModelView {
    private String viewName;
    private Map<String,Object> model = new HashMap<>();
    //model에서 원하는 객체를 넣으면 jsp에서 사용할 수 있도록 후처리

   public ModelView(String viewName){
        this.viewName = viewName;
    }




}
